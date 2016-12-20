/**
 * 
 */
package com.brain.study.concurrency.executor.schedule;

import java.util.concurrent.Callable;

/**
 * @author brain
 *
 */
public class Task implements Callable<String> {
	private String id;
	private long creatTime;

	Task(String id) {
		this.id = "Task-" + id;
		creatTime = System.currentTimeMillis();
	}

	@Override
	public String call() throws Exception {
		System.out.println("开始执行时间：" + ((System.currentTimeMillis() - creatTime) / 1000) + " " +id + "   " + Thread.currentThread().getName());
		return id;
	}
}