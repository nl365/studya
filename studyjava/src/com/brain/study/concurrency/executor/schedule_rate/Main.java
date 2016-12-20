/**
 * 
 */
package com.brain.study.concurrency.executor.schedule_rate;

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
		// 延迟1s，然后每隔5s执行一次
		// 发现即便线程池中可以有4个线程来处理任务但是任务仍然是处理完了才回发出下一个task，如果task时间超过了设定的delay时间，会等待task结束再进行下一个task
		ScheduledFuture<?> sf = exec.scheduleAtFixedRate(new Task("[schedule task]"), 1, 5, TimeUnit.SECONDS);

		System.out.println("=========main end");
	}
}
