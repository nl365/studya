/**
 * 
 */
package com.brain.study.concurrency.executor_future_invokeall;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author brain
 *
 */
public class Task implements Callable<String> {
	private String id;
	private int workTime;

	Task(String id, int workTime) {
		this.id = "Task-" + id;
		this.workTime = workTime;
	}

	@Override
	public String call() throws Exception {
		try {
			TimeUnit.SECONDS.sleep(workTime);
		} catch (InterruptedException e) {
			System.out.println(id + "   " + "InterruptedException");
		}
		System.out.println(id + "   " + Thread.currentThread().getName());

		return id;
	}
}