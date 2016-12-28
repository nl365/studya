/**
 * 
 */
package com.brain.study.test.interview;

/**
 * 【程序24】 题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 * @author brain
 */
public class Test24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("count=" + caculate(90201));
	}

	public static int caculate(int num) {
		if (num > 99999) {
			return -1;
		}
		int[] array = new int[5];
		for (int i = 0; i < 5; i++) {
			array[i] = num % 10;
			System.out.println(array[i]);
			num = num / 10;
		}
		int count = 5;
		for (int i = 4; i >= 0; i--) {
			if (array[i] == 0) {
				count--;
			} else {
				break;
			}
		}

		return count;
	}

}
