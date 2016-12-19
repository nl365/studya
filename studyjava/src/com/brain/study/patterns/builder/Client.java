package com.brain.study.patterns.builder;

public class Client {
	public static void main(String[] args) {
		ConcreteBuilder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		director.construct();
		Product product = builder.getResult();
		product.doSomething();
	}
}
