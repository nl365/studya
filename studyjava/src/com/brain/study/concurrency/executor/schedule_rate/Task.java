/**
 * 
 */
package com.brain.study.concurrency.executor.schedule_rate;

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
			// Thread.sleep(2000);// 2s 没有超过了设定的delay时间 会按设定的delay时间进行下一个task
			Thread.sleep(6000); // 6s 超过了设定的delay时间，会等待task结束再进行下一个task
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行结束 " + id + "   " + Thread.currentThread().getName());
	}
}