/**
 * 
 */
package com.brain.study.concurrency.sync_wait;

/**
 * @author brain
 *
 */
public class Producer implements Runnable {

	private EventStorage storage;

	public Producer(EventStorage storage) {
		this.storage = storage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			storage.set();
		}
	}
}
