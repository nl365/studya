/**
 * 
 */
package com.brain.study.test.interview;

/**
 题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。 
 * @author brain
 *
 */
public class Test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(caculate(60));
	}

	private static String caculate(int i) {
		return i >= 90 ? "A" : (i >= 60 ? "B" : "C");
	}

}
