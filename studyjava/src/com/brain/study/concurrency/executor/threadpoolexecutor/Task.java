/**
 * 
 */
package com.brain.study.concurrency.executor.threadpoolexecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author brain
 *
 */
public class Task implements Callable<String> {
	private String id;

	Task(String id) {
		this.id = "Task-" + id;
	}

	@Override
	public String call() throws Exception {
		System.out.println("call -> start " + id + "   " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("call -> end " + id + "   " + Thread.currentThread().getName());

		return id;
	}
}
