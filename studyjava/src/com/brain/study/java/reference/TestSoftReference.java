/**
 * 
 */
package com.brain.study.java.reference;

import java.lang.ref.SoftReference;

/**
 * @author brain
 *
 */
public class TestSoftReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SoftReference<String> sr = new SoftReference<String>(
				new String("test SoftReference"));
		System.out.println(sr.get());
		System.gc();
		System.out.println("System.gc();");
		System.out.println(sr.get());
	}

}
