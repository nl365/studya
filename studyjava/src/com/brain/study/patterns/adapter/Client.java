/**
 * 
 */
package com.brain.study.patterns.adapter;

/**
 * Client
 * @author Brain
 * @date 2014-12-7
 */
public class Client {

	public static void main(String[] args) {
		ITarget target = new Adapter();
		new Client().needTargetInterface(target);
	}
	
	private void needTargetInterface(ITarget target) {
		target.request();
	}

}
