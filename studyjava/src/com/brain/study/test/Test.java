package com.brain.study.test;

public class Test<T extends Object> {
	public static void main(String[] args) {
		Test<Object> eTest = new Test<>();// 泛型的extends包含性
	}
}
