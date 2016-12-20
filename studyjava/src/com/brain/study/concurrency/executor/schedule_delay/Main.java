/**
 * 
 */
package com.brain.study.concurrency.executor.schedule_delay;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService#scheduleAtFixedRate
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
		final ScheduledExecutorService exec = Executors.newScheduledThreadPool(4, new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});
		// task执行结束再延迟5s 启动下一个task
		ScheduledFuture<?> sf = exec.scheduleWithFixedDelay(new Task("[schedule task]"), 1, 5, TimeUnit.SECONDS);
		System.out.println("sf.isDone()=" + sf.isDone());

		System.out.println("=========main end");
	}
}
