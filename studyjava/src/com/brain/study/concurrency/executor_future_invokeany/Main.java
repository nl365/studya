/**
 * 
 */
package com.brain.study.concurrency.executor_future_invokeany;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * exec.invokeAny线程竞赛只用最快的结果。通过结果可以看出当最快的结果返回后，执行器中断了其它所有线程，没有执行的task也从队列里清除了。
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
		tasks.add(new Task("1sTask3", 1));
		tasks.add(new Task("10sTask", 10));
		String result = null;
		try {
			result = exec.invokeAny(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("result  = " + result);
		System.out.println("=========main end");
	}

}
