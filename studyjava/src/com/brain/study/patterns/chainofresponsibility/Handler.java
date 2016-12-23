/**
 * 
 */
package com.brain.study.patterns.chainofresponsibility;

/**
 * Handler
 * 责任链模式定义一组可以处理请求的对象，将他们连成链，让请求在链上传递，直到有对象处理了它为止。
 * @author Brain
 * @date 2014-12-8
 */
public abstract class Handler {

	protected Handler successor;

	public Handler getSuccessor() {
		return successor;
	}

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	public abstract void handleRequest();
}