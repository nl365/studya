/**
 * 
 */
package com.brain.study.concurrency.thread2;

import java.lang.Thread.UncaughtExceptionHandler;

import com.brain.study.concurrency.thread1.Calculator;

/**
 * @author brain
 *
 */
public class Main {

	/**
	 * 关注线程的get方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread = new Thread(new Calculator());
		System.out.println("getId=" + thread.getId());
		System.out.println("getName = " + thread.getName());
		System.out.println("getPriority = " + thread.getPriority());
		System.out.println("getState = " + thread.getState());
		System.out.println("getThreadGroup = " + thread.getThreadGroup());
		System.out.println("getUncaughtExceptionHandler = " + thread.getUncaughtExceptionHandler());

		System.out.println("=============");
		System.out.println("thread.toString()=" + thread.toString());
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub

			}
		});
		System.out.println("getUncaughtExceptionHandler = " + thread.getUncaughtExceptionHandler());
	}

}
