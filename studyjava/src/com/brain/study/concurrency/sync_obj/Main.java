/**
 * 
 */
package com.brain.study.concurrency.sync_obj;

/**
 * 生产者和消费者，用object进行同步
 * @author brain
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {  
	    EventStorage storage = new EventStorage();  
	    new Thread(new Producer(storage)).start();  
	    new Thread(new Consumer(storage)).start();  
	}  
}
