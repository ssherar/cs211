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
		this.random = new Random();
	}
	
	@Override
	public Job getNextJob() throws SchedulerException {
		Job returnJob;
		if(this.numberOfItems < 1) throw new SchedulerException("Queue is empty");
		Collections.shuffle(this.queue, this.random);
		returnJob = (Job)this.queue.get(0);
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
		// TODO randomize the location of the queue.
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
