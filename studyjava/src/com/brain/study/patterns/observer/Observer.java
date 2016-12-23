/**
 * 
 */
package com.brain.study.patterns.observer;

/**
 * Observer
 * 定义一种一对多的依赖关系，使得一个对象发生某种变换时候，可以通知所有依赖它的对象做出相应的改变。
 * @author Brain
 * @date 2014-12-8
 */
public interface Observer {
	void update();
}
