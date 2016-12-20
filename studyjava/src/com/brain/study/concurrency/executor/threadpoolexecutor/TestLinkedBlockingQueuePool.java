/**
 * 
 */
package com.brain.study.concurrency.executor.threadpoolexecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.brain.study.concurrency.ConcurrencyUtils;

/**
 * 无界阻塞队列
 * 
 * @author brain
 *
 */
public class TestLinkedBlockingQueuePool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("=========main start");
		final ThreadPoolExecutor exec = new ThreadPoolExecutor(1, 128, 10000L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {

					@Override
					public Thread newThread(Runnable r) {
						return new Thread(r);
					}
				});
		ConcurrencyUtils.printThreadPoolExecutorInfo(exec);

		for (int i = 0; i < 10; i++) {
			exec.submit(new Task(String.valueOf(i)));
		}

		do {
			ConcurrencyUtils.printThreadPoolExecutorInfo(exec);
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

}
