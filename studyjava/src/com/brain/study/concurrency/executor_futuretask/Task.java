package com.brain.study.concurrency.executor_futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;

public class Task implements Callable<String> {
	private String id;

	Task(String id) {
		this.id = "Task-" + id;
	}

	@Override
	public String call() throws Exception {

		System.out.println(id + "   " + Thread.currentThread().getName());

		return id;
	}

	public static void main(String[] args) {
		System.out.println("=========main start");
		final ExecutorService exec = Executors.newSingleThreadExecutor(new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});

		FutureTask<String> ftask = new FutureTask<String>(new Task("task")) {

			@Override
			protected void done() {
				System.out.println("=========FutureTask done");
				super.done();
			}

		};
		exec.submit(ftask);

		System.out.println("=========main end");
	}
}