package com.brain.study.concurrency.sync_lock;

public class PrintQueue {
	public PrintQueue() {
	}

	public synchronized void printJob(Object doc) {
		long duration = (long) (Math.random() * 10000);
		System.out.println(Thread.currentThread().getName() + " :  start print " + (duration / 1000) + " secs");
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :   print completed");
	}

	static class Job implements Runnable {

		private PrintQueue queue;

		public Job(PrintQueue queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " run start");
			queue.printJob(new Object());
			System.out.println(Thread.currentThread().getName() + " run end");
		}

	}

	public static void main(String[] args) {
		PrintQueue queue = new PrintQueue();
		for (int i = 0; i < 10; i++) {
			new Thread(new Job(queue)).start();
		}

	}
}