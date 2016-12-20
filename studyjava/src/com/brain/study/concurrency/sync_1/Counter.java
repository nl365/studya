/**
 * 
 */
package com.brain.study.concurrency.sync_1;

/**
 * @author brain
 *
 */
public class Counter {
	private int count;

	public Counter(int count) {
		init(count);
	}

	public void init(int count) {
		this.count = count;
	}

	public void add() {
		this.count++;
	}

	public /*synchronized*/ void subtraction() { // 如果不进行线程同步 count出现负值的情况 加上 synchronized 就不一样了
		if (this.count > 0) { 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.count--;
			System.out.println("subtraction " + count);
		}
	}

	public int getCount() {
		return this.count;
	}

}