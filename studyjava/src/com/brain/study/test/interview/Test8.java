/**
 * 
 */
package com.brain.study.test.interview;

import com.sun.security.auth.NTDomainPrincipal;

/**
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，
 * 几个数相加有键盘控制。
 * 
 * @author brain
 *
 */
public class Test8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(caculate(0, 10));
		System.out.println(caculate(1, 3));
		System.out.println(caculate(2, 4)); // 2 + 22 + 222 +2222
		System.out.println( 2 + 22 + 222 +2222); 
		System.out.println(caculate(9, 10));
	}

	public static long caculate(int a, int count) {
		long sum = 0;
		for (int i = 0; i < count; i++) {
			sum += getNum(a, i);
		}
		return sum;
	}

	private static long getNum(int a, int index) {
		int num = a;
		int temp = 1;
		for (int i = 0; i < index; i++) {
			temp *= 10; 
			num = num +  a * temp;
		}
		return num;

	}
}
