/**
 * 
 */
package com.brain.study.concurrency.executor.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * schedule ScheduledExecutorService#awaitTermination
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
		final ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});
		
		// schedule是不阻塞的，两个延迟任务，分别在放入exec中后相应延迟时间后启动
		exec.schedule(new Task("[schedule task]"), 5, TimeUnit.SECONDS);	// 延迟5s后执行task
		exec.schedule(new Task("[schedule task2]"), 1, TimeUnit.SECONDS); 	// 第二个任务比第一个延迟时间短
		
		try {
			exec.awaitTermination(6, TimeUnit.SECONDS); // 用于等待子线程结束,再继续执行下面的代码。
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=========main end");
	}
}
