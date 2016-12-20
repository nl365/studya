/**
 * 
 */
package com.brain.study.concurrency.executor.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor#setExecuteExistingDelayedTasksAfterShutdownPolicy
 * 
 * @author brain
 *
 */
public class Main2 {

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
		exec.schedule(new Task("[schedule task1]"), 3, TimeUnit.SECONDS);
		exec.schedule(new Task("[schedule task2]"), 1, TimeUnit.SECONDS);
		/**
		 * 改变了策略shutdown,传入false时再调用shutdown会产生和shutdownNow一样的效果（不仅schedule的task都没有执行，awaitTermination也没有作用了 直接输出end了）
		 */
	    ((ScheduledThreadPoolExecutor)exec).setExecuteExistingDelayedTasksAfterShutdownPolicy(false);  
		exec.shutdown();  // 由于上面一句改变了shutdow的策略，这里shutdown和shutdownNow效果一样，awaitTermination设置失效，不再等待10s
		
		try {
			exec.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=========main end");
	}
}
