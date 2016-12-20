/**
 * 
 */
package com.brain.study.concurrency.executor.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService#shutdownNow  shutdown
 * 
 * @author brain
 *
 */
public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("=========main start");
		final ScheduledExecutorService exec = Executors.newScheduledThreadPool(4, new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});
		exec.schedule(new Task("[schedule task1]"), 3, TimeUnit.SECONDS);
		exec.schedule(new Task("[schedule task2]"), 1, TimeUnit.SECONDS);
		
//		exec.shutdown();  // 这里shutdown不能阻止schedule的task，仍然按延迟时间执行了，awaitTermination设置失效，不再等待10s
		exec.shutdownNow();  // 这里shutdownNow阻止延迟的task执行，同时awaitTermination设置失效，不再等待
		try {
			exec.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=========main end");
	}
}
