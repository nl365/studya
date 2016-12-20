/**
 * 
 */
package com.brain.study.concurrency.thread1;

/**
 * @author brain
 *
 */
public class Calculator implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "   " + i);
		}
	}
}
