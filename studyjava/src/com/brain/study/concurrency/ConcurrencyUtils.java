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
		System.out.println("--------");

	}
	/**
	 * 打印线程池信息
	 * 
	 * @param exec
	 */
	public static void printThreadPoolExecutorInfo(ThreadPoolExecutor exec) {
		printThreadPoolExecutorInfo(exec,"thread pool info");
	}
	
	/**
	 * 打印线程池信息
	 * 
	 * @param exec
	 */
	public static void printThreadPoolExecutorInfo(ThreadPoolExecutor exec, String describe) {
		if (exec == null) {
			throw new IllegalArgumentException("exec is unll!");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("--- ");
		sb.append(describe);
		sb.append(" ---\n");
		sb.append("exec.getPoolSize()=");
		sb.append(exec.getPoolSize());
		sb.append("\n");
		
		sb.append("exec.getCorePoolSize()=");
		sb.append(exec.getCorePoolSize());
		sb.append("\n");
		
		sb.append("exec.getLargestPoolSize()=");
		sb.append(exec.getLargestPoolSize());
		sb.append("\n");
		
		sb.append("exec.getMaximumPoolSize()=");
		sb.append(exec.getMaximumPoolSize());
		sb.append("\n");
		
		sb.append("exec.getActiveCount()=");
		sb.append(exec.getActiveCount());
		sb.append("\n");
		
		sb.append("exec.getTaskCount()=");
		sb.append(exec.getTaskCount());
		sb.append("\n");
		
		sb.append("exec.getCompletedTaskCount()=");
		sb.append(exec.getCompletedTaskCount());
		sb.append("\n");
		sb.append("--------\n");
		System.out.println(sb.toString());
	}

}
