package com.brain.study.concurrency.executor_singlethreadexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private String id;

	Task(int id) {
		this.id = "Task-" + id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(id + "   " + i + "   " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		System.out.println("=========main start");
		// 注意：newSingleThreadExecutor和newSingleThreadScheduledExecutor返回是DelegatedExecutorService对象
		// 不能使用ThreadPoolExecutor来引用
		// FinalizableDelegatedExecutorService继承自DelegatedExecutorService
		// DelegatedScheduledExecutorService继承自DelegatedExecutorService
		// 实现了ScheduledExecutorService
		final ExecutorService exec = Executors.newSingleThreadExecutor(new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});

		for (int i = 0; i < 10; i++) {
			exec.execute(new Task(i));
		}

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("=========main end");
	}
}