/**
 * 
 */
package com.brain.study.concurrency.threadinterrupted;

/**
 * @author brain
 *
 */
class MyRunnable2 implements Runnable {

	private int i = 0;

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " run "
				+ Thread.currentThread().isInterrupted());
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName() + " try "
						+ Thread.currentThread().isInterrupted());

				Thread.sleep(100);

			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()
						+ " InterruptedException "
						+ Thread.currentThread().isInterrupted());
			}
			if (Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName()
						+ " isInterrupted true");
				return;
			} else {
				System.out.println(Thread.currentThread().getName() + "   "
						+ (i++));
			}
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnable2());
		System.out.println(thread + " main1 "
				+ thread.isInterrupted());
		
		thread.start();
		System.out.println(thread + " main2 "
				+ thread.isInterrupted());
		thread.interrupt();
	}
}