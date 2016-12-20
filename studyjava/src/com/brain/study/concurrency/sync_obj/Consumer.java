/**
 * 
 */
package com.brain.study.concurrency.sync_obj;

/**
 * @author brain
 *
 */

public class Consumer implements Runnable {

	private EventStorage storage;

	public Consumer(EventStorage storage) {
		this.storage = storage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			storage.get();
		}
	}
}