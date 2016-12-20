package com.brain.study.concurrency.executor_future_submit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Task implements Runnable {
	private String id;

	Task(int id) {
		this.id = "Task-" + id;
	}

	Task(String id) {
		this.id = "Task-" + id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(id + "   " + i + "   " + Thread.currentThread().getName());
		}
	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println("=========main start");
		final ExecutorService exec = Executors.newFixedThreadPool(4, new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});

		Callable<Task> callable = new Callable<Task>() {

			@Override
			public Task call() throws Exception {
				System.out.println("call " + "   " + Thread.currentThread().getName());

				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return new Task("call中的task");
			}

		};
		Future<Task> future = exec.submit(callable); // 调用submit返回一个结果，结果是Callable中call()方法返回的
														// 是一个Runnble对象

		Task command = null;
		try {
			System.out.println("=========future.get s");
			command = future.get(2, TimeUnit.SECONDS);
			System.out.println("=========future.get e");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		// 通过future.get()获得返回的结果对象，这个对象是个runnable对象可以 再用执行器执行
		exec.execute(command);
		exec.execute(command);
		exec.execute(command);
		exec.execute(command);
		System.out.println("=========main end");
	}

}