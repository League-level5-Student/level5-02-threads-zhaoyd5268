package _04_Thread_Pool.tests;

import java.lang.Thread.State;
import java.util.ArrayDeque;

public class WorkQueue implements Runnable {

	private ArrayDeque<Job> jobQueue = new ArrayDeque<Job>();
	private Thread[] threads;
	private volatile boolean isRunning = true;

	public WorkQueue() {
		int TotalThreadCount = Runtime.getRuntime().availableProcessors() - 1;
		threads = new Thread[TotalThreadCount];

	}

	@Override
	public void run() {
		while (isRunning) {
			if (!performJob()) {
				synchronized (jobQueue) {
					try {
						jobQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public int length() {
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(this);
			threads[i].start();
		}
		return threads.length;
	}

	public void shutdown() {
		completeAllJobs();
		isRunning = false;
		synchronized (jobQueue) {
			jobQueue.notifyAll();
		}

	}

	public void addJob(Job x) {
		synchronized (jobQueue) {
			jobQueue.add(x);
			jobQueue.notify();
		}

	}

	public boolean performJob() {
		Job j = null;
		synchronized (jobQueue) {
			if (!jobQueue.isEmpty()) {
				j = jobQueue.remove();
			}
		}
			if (j != null) {
				j.Perform();
				return true;
			} else {
				return false;
			}


	}
	
	public void completeAllJobs() {
		while (!jobQueue.isEmpty()) {
			performJob();
		}
		
		for (int i = 0; i < threads.length; i++) {
			if (threads[i].getState() != State.WAITING) {
				i = -1;
			}
		}
		
	}
}
