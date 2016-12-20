/**
 * 
 */
package com.brain.study.concurrency.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.brain.study.concurrency.ConcurrencyUtils;

/**
 * @author brain
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("=========main start");
		final ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newCachedThreadPool(new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});
		exec.execute(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					System.out.println("AAA--" + i);
				}
			}
		});

		exec.execute(new Runnable() {
			@Override
			public void run() {

				for (int i = 0; i < 200; i++) {
					System.out.println("BBB--" + i);
				}
			}
		});

		exec.execute(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					System.out.println("CCC--" + i);
				}

			}
		});

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConcurrencyUtils.printThreadPoolExecutorInfo(exec);

		System.out.println("=========main end");
	}

}
