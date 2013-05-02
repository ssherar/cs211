package uk.ac.aber.rcs.cs211.schedulersim.scheduler;

import uk.ac.aber.rcs.cs211.schedulersim.Job;
import uk.ac.aber.rcs.cs211.schedulersim.Scheduler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LotteryScheduler implements Scheduler {
	protected ArrayList<Job> queue;
	private int numberOfItems;
	private Random random;

	
	public LotteryScheduler() {
		this.queue = new ArrayList<Job>();
		this.numberOfItems = 0;
		this.random = new Random(System.currentTimeMillis());
	}
	
	@Override
	public Job getNextJob() throws SchedulerException {
		ArrayList<Job> tickets = new ArrayList<Job>();
		Job returnJob;
		if(this.numberOfItems < 1) throw new SchedulerException("Queue is empty");
		for(Job j: this.queue) {
			for(int i = 0; i < j.getPriority(); i++) {
				tickets.add(j);
			}
		}
		Collections.shuffle(tickets, this.random);
		returnJob = (Job)tickets.get(0);
		return returnJob;
	}

	@Override
	public void addNewJob(Job job) throws SchedulerException {
		if(this.queue.contains(job)) throw new SchedulerException("Already In Queue");
		this.queue.add(numberOfItems, job);
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
		//reset the seed for more randomness
		this.random.setSeed(System.currentTimeMillis());
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
