package com.brain.study.concurrency.executor_shutdown;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.brain.study.concurrency.ConcurrencyUtils;

public class Task implements Runnable {
	private String id;

	Task(int id) {
		this.id = "Task-" + id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(id + "   " + i);
		}
	}

	public static void main(String[] args) {
		System.out.println("=========main start");
		final ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newFixedThreadPool(5, new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});

		for (int i = 0; i < 10; i++) {
			exec.execute(new Task(i));
		}
		/**
		 * shutdown()和shutdownNow();都不能终止已经执行的任务，再增加新的任务会向执行器所在线程抛出RejectedExecutionException异常，
		 * 如未处理该处理异常，执行器所在线程将终止，但是执行器中的任务还将继续执行。
		 * shutdownNow会将排队的任务舍弃，shutdown则会将队列中的任务执行完毕。
		 */
		// shutdownNow
		// exec.shutdownNow();
		// System.out.println(">>>>>>>>>>>>>>>shutdownNow");

		// shutdown
		exec.shutdown();
		System.out.println(">>>>>>>>>>>>>>>shutdown");

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ConcurrencyUtils.printThreadPoolExecutorInfo(exec);

		System.out.println("=========main end");
	}
}