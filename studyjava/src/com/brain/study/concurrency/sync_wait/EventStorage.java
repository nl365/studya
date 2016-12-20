package com.brain.study.concurrency.sync_wait;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {

	private int maxSize;
	private LinkedList<Date> storage;

	/** 
	 *  
	 */
	public EventStorage() {
		super();
		this.maxSize = 500;
		this.storage = new LinkedList<Date>();
	}

	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		storage.add(new Date());
		System.out.printf("Set: %d\n", storage.size());
		notifyAll();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d, %s\n", storage.size(), storage.poll());
		notifyAll();
	}
}