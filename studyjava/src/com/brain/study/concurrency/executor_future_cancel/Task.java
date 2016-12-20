package com.brain.study.concurrency.executor_future_cancel;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private String id;

	Task(String id) {
		this.id = "Task-" + id;
	}

	@Override
	public void run() {
		System.out.println(new Date() + ":" + id + "  task start  " + Thread.currentThread().getName());

		while (true) {
			System.out.println(new Date() + ":" + id + "  task running  " + Thread.currentThread().getName());

		}

	}


	public static void main(String[] args) {
		System.out.println("=========main start");
		final ExecutorService exec = Executors.newSingleThreadExecutor(new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});

		Future<?> f = exec.submit(new Task("task"));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.cancel(true); // ??
		System.out.println("=========main end");
	}

}