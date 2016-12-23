package com.brain.study.patterns.bridge;

/**
 * Bridge模式将抽象部分和实现部分相分离，使得他们可以独立变换
 * @author brain
 *
 */
public class Client {

	public static void main(String[] args) {
		Abstraction abstraction = new RefinedAbstraction();
		abstraction.setImplementor(new ConcreteImplementorA());
		abstraction.operation();

		abstraction.setImplementor(new ConcreteImplementorB());
		abstraction.operation();
	}

}
