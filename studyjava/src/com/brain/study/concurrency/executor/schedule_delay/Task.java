/**
 * 
 */
package com.brain.study.concurrency.executor.schedule_delay;

import java.util.concurrent.TimeUnit;

/**
 * @author brain
 *
 */
public class Task implements Runnable {
	private String id;
	private long creatTime;

	Task(String id) {
		this.id = "Task-" + id;
		creatTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		System.out.println("开始执行  时间：" + ((System.currentTimeMillis() - creatTime) / 1000) + " " + id + "   "
				+ Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(10); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行结束 " + id + "   " + Thread.currentThread().getName());
	}
}