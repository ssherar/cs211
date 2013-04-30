package uk.ac.aber.rcs.cs211.schedulersim.scheduler;

import uk.ac.aber.rcs.cs211.schedulersim.Job;
import uk.ac.aber.rcs.cs211.schedulersim.Scheduler;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Random;

public class ShortestTime implements Scheduler {
	protected LinkedList<Job> queue;
	private int numberOfItems;

	
	public ShortestTime() {
		this.queue = new LinkedList<Job>();
		this.numberOfItems = 0;
	}
	
	@Override
	public Job getNextJob() throws SchedulerException {
		Job returnJob;
		if(this.numberOfItems < 1) throw new SchedulerException("Queue is empty");
		returnJob = (Job)this.queue.get(0);
		return returnJob;
	}

	@Override
	public void addNewJob(Job job) throws SchedulerException {
		if(this.queue.contains(job)) throw new SchedulerException("Already In Queue");
		boolean inserted = false;
		for(int i = 0; i < numberOfItems && !inserted; i++) {
			System.out.println();
			if(job.getLength() - job.getStartCycle() - job.getProgramCounter() < 
					this.queue.get(i).getLength() - this.queue.get(i).getProgramCounter()
					-this.queue.get(i).getStartCycle()) {
				System.out.println("inserted before element " + i);
				this.queue.add(i, job);
				inserted = true;
			}
		}
		if(!inserted) this.queue.add(job);
		this.numberOfItems++;
	}

	@Override
	public void returnJob(Job job) throws SchedulerException {
		if(!this.queue.contains(job)) throw new SchedulerException("Job not in queue");
	}

	@Override
	public void removeJob(Job job) throws SchedulerException {
		if( !this.queue.contains(job)) throw new SchedulerException("Job not in queue");
		this.queue.remove(job);
		this.numberOfItems--;
	}

	@Override
	public void reset() {
		this.queue.clear();
		this.numberOfItems = 0;
	}

	@Override
	public Job[] getJobList() {
		Job[] jobs = new Job[queue.size()];
		for (int i=0; i<queue.size(); i++) {
			jobs[i]=this.queue.get(i);
		}
		return jobs;
	}

}
