/**
 * 
 */
package com.brain.study.test.interview;

/**
 * 【程序1】
	題目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
	分析：斐波拉切数列
	1  1
	2  1
	3  2
	4  3
	5  5
	6  8
 * @author brain
 *
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getFibonacciNumLoop(3000));
	}

	public static long getFibonacciNum(int index) {
		if (index < 0) {
			return 0L;
		}
		if (index == 1 || index == 2) {
			return 1L;
		} else {
			return getFibonacciNum(index - 1) + getFibonacciNum(index - 2);
		}
	}
	
	
	public static long getFibonacciNumLoop(int index) {
		if (index < 0) {
			return 0L;
		} else if (index == 1 || index == 2) {
			return 1;
		}
		long a = 1;
		long b = 1;
		long s = 0;
		for (int i = 3; i <= index; i++) {
			s = a + b;
			a = b;
			b = s;
		}
		return s;
	}
}
