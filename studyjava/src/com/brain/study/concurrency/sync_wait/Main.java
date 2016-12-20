/**
 * 
 */
package com.brain.study.concurrency.sync_wait;

import java.util.concurrent.TimeUnit;

/**
 * 生产者和消费者，用wait notifyAll方法进行同步 wait会让线程就在wait调用处等待，并且释放锁。 sleep只是等待,不会释放同步锁。
 * 
 * @author brain
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		Thread producer = new Thread(new Producer(storage));
		Thread consumer = new Thread(new Consumer(storage));
		producer.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumer.start();
	}
}
