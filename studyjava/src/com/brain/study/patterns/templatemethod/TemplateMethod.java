/**
 * 
 */
package com.brain.study.patterns.templatemethod;

/**
 * TemplateMethod
 * 定义一个算法的骨架，将一些步骤延迟到子类中实现，使得可以不改变算法结构就可以重新定义算法的关键步骤
 * 如：Android Activity的生命周期方法
 * @author Brain
 * @date 2014-12-8
 */
public abstract class TemplateMethod {

	public void doSomething() {
		@SuppressWarnings("unused")
		Object obj = getPrerequisite();
		// do something
		completed(new Object());
	}

	protected abstract void completed(Object result);

	protected abstract Object getPrerequisite();
}
