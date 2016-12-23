package com.brain.study.patterns.mediator;

/**
 * 
 * Mediator
 * 用一个中介对象封装一系列对象的交互，各个对象不需要显示的相互调用，降低了耦合
 * 可以独立改变对象间的交互 而不影响既有的对象
 * @author Brain
 * @date 2014-12-8
 */
public abstract class Mediator {
	public abstract void colleagueChanged(Colleague colleague);
}
