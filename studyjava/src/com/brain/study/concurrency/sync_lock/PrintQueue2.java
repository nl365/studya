package com.brain.study.concurrency.sync_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue2 {
	//	private Lock queueLock = new ReentrantLock();
    private final Lock queueLock = new ReentrantLock(true);  // 传入fair 为true  

	public PrintQueue2() {
	}

	public void printJob(Object doc) {  
	    queueLock.lock();  
	    System.out.println("queueLock.lock()");  
	    long duration = (long) (Math.random() * 10000 );  
	    System.out.println(Thread.currentThread().getName() + " :  start print " + (duration / 1000) + " secs");  
	    try {  
	        Thread.sleep(duration);  
	    } catch (InterruptedException e) {  
	        e.printStackTrace();  
	    } finally {  
	        System.out.println("queueLock.unlock()");  
	        queueLock.unlock();  
	    }  
	    System.out.println(Thread.currentThread().getName() + " :   print completed");  
	}  
	
	/**
	 * Job
	 * @author brain
	 *
	 */
	static class Job implements Runnable {

		private PrintQueue2 queue;

		public Job(PrintQueue2 queue) {
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
		PrintQueue2 queue = new PrintQueue2();
		for (int i = 0; i < 10; i++) {
			new Thread(new Job(queue)).start();
		}

	}
}