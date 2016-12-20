package com.brain.study.concurrency.sync_obj;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {

	private int maxSize;
	private LinkedList<Date> storage;

	private Object lock = new Object();

	public EventStorage() {
		super();
		this.maxSize = 2;
		this.storage = new LinkedList<Date>();
	}

	public void set() {
		synchronized (lock) {
			while (storage.size() == maxSize) {
				System.out.println("set while start = " + storage.size());

				try {
					System.out.println("set lock.wait() start");
					lock.wait();// 让获得该锁的当前线程进入等待队列
					System.out.println("set lock.wait() end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("set while end = " + storage.size());
			}

			storage.add(new Date());
			System.out.printf("Set: %d\n", storage.size());
			System.out.println("set lock.notifyAll() start");
			lock.notifyAll();// 告知该锁的等待队列中的线程
			System.out.println("set lock.notifyAll() end");
		}
	}

	public void get() {
		synchronized (lock) {
			while (storage.size() == 0) {
				System.out.println("get while start = " + storage.size());
				try {
					System.out.println("get lock.wait() start");
					lock.wait();// 让获得该锁的当前线程进入等待队列
					System.out.println("get lock.wait() end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("get while end = " + storage.size());
			}
			System.out.printf("Get: %d, %s\n", storage.size(), storage.poll());
			System.out.println("get lock.notifyAll() start");
			lock.notifyAll();// 告知该锁的等待队列中的线程,可以来获得CPU
			System.out.println("get lock.notifyAll() end");
		}
	}
}