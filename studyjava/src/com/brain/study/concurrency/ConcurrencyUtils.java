/**
 * 
 */
package com.brain.study.concurrency;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author brain
 *
 */
public class ConcurrencyUtils {

	/**
	 * 打印线程息
	 * 
	 * @param exec
	 */
	public static void printThreadInfo(Thread thread) {
		if (thread == null) {
			throw new IllegalArgumentException("thread is unll!");
		}
		System.out.println("getId=" + thread.getId());
		System.out.println("getName = " + thread.getName());
		System.out.println("getPriority = " + thread.getPriority());
		System.out.println("getState = " + thread.getState());
		System.out.println("getThreadGroup = " + thread.getThreadGroup());
		System.out.println("getUncaughtExceptionHandler = " + thread.getUncaughtExceptionHandler());

	}

	/**
	 * 打印线程池信息
	 * 
	 * @param exec
	 */
	public static void printThreadPoolExecutorInfo(ThreadPoolExecutor exec) {
		if (exec == null) {
			throw new IllegalArgumentException("exec is unll!");
		}
		System.out.println("exec.getPoolSize()=" + exec.getPoolSize());
		System.out.println("exec.getCorePoolSize()=" + exec.getCorePoolSize());
		System.out.println("exec.getLargestPoolSize()=" + exec.getLargestPoolSize());
		System.out.println("exec.getMaximumPoolSize()=" + exec.getMaximumPoolSize());
		System.out.println("exec.getActiveCount()=" + exec.getActiveCount());
		System.out.println("exec.getTaskCount()=" + exec.getTaskCount());
		System.out.println("exec.getCompletedTaskCount()=" + exec.getCompletedTaskCount());
	}

}
