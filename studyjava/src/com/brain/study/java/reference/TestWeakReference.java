/**
 * 
 */
package com.brain.study.java.reference;

import java.lang.ref.WeakReference;

/**
 * @author brain
 *
 */
public class TestWeakReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeakReference<String> sr = new WeakReference<String>(
				new String("test WeakReference"));
		System.out.println(sr.get());
		System.gc();
		System.out.println("System.gc();");
		System.out.println(sr.get());
	}

}
