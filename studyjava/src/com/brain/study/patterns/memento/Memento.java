package com.brain.study.patterns.memento;

/**
 * Memento
 * 不破坏封装的前提下，将一个对象内部的状态保存在对象外，并且以后可以用来恢复对象
 * @author Brain
 * @date 2014-12-8
 */
public class Memento {
	private Object state = null;

	public Memento() {
	}

	public Memento(Object state) {
		setState(state);
	}

	public Object getState() {
		return state;
	}

	public void setState(Object state) {
		this.state = state;
	}

}
