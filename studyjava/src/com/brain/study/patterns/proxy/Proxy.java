/**
 * 
 */
package com.brain.study.patterns.proxy;

/**
 * Proxy
 * 为其他对象提供一种代理以控制这个对象的访问
 * @author Brain
 * @date 2014-12-8
 */
public class Proxy implements Subject {

	private Subject subject = null;

	public Proxy(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void request() {
		if (this.subject != null) {
			// this.subject.request();
		}
	}
}