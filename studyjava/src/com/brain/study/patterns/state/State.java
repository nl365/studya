/**
 * 
 */
package com.brain.study.patterns.state;

/**
 * State
 * 允许对象在改变其内部状态时候改变其行为，就像改变了类型
 * 通常状态定义对内部类或静态内部类 
 * 和策略模式UML一样 但表达的意思有所区别
 * @author Brain
 * @date 2014-12-8
 */
public interface State {
	void handle();
}
