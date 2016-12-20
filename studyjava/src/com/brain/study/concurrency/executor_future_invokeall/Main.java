/**
 * 
 */
package com.brain.study.concurrency.executor_future_invokeall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * exec.invokeAll返回的List<Future<T>>是用来获得任务的结果，因为invokeAll是阻塞的， 返回时候所有的任务都已经完成了。
 * 也就是所有的Future对象isDone()都会返回true
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
		final ExecutorService exec = Executors.newFixedThreadPool(4, new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("2sTask", 2));
		tasks.add(new Task("3sTask1", 3));
		tasks.add(new Task("3sTask2", 3));
		tasks.add(new Task("3sTask3", 3));
		tasks.add(new Task("1sTask1", 1));
		tasks.add(new Task("1sTask2", 1));
		tasks.add(new Task("10sTask", 10)); // 有一个10s的task
		tasks.add(new Task("1sTask3", 1));

		List<Future<String>> results = null;

		try {
			// results = exec.invokeAll(tasks);	
			results = exec.invokeAll(tasks, 6, TimeUnit.SECONDS); 	// 可以设置timeout，没有timeout就是等待所有任务完成
																	// 这个timeout是完成所有的任务的时限
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (Future<String> result : results) {
			try {
				System.out.println("result  = " + result.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (java.util.concurrent.CancellationException e) { // timeout时候抛出 是runtime异常
				e.printStackTrace();
			}
		}
		System.out.println("=========main end");
	}

}
