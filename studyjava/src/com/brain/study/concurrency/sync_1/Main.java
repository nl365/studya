/**
 * 
 */
package com.brain.study.concurrency.sync_1;

/**
 * 实验没有同步访问临界区的情况
 * 
 * @author brain
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("=========main start");
		final Counter counter = new Counter(10);
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					counter.subtraction();
				}
				System.out.println("run1 " + counter.getCount());
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					counter.subtraction();
				}
				System.out.println("run2 " + counter.getCount());

			}
		}.start();

		System.out.println("=========main end");
	}

}
