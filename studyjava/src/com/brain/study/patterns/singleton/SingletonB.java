/**
 * 
 */
package com.brain.study.patterns.singleton;

/**
 * Singleton懒汉式需要synchronized
 * 
 * @author Brain
 * @date 2014-12-7
 */
public class SingletonB {
	private static SingletonB instance = null;

	private SingletonB() {
	}

	public static synchronized SingletonB getInstacne() {
		if (instance == null) {
			instance = new SingletonB();
		}
		return instance;
	}
}
