/**
 * 
 */
package com.brain.study.patterns.adapter;

/**
 * Adapter
 * 将一个类的接口转换成用户期望的接口，使得原本不能再一起工作的两个类可以一起工作
 * @author Brain
 * @date 2014-12-7
 */
public class Adapter extends Adaptee implements ITarget {

	/**
	 * 
	 */
	public Adapter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void request() {
		specificRequest();
	}
}
