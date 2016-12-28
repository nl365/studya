/**
 * 
 */
package com.brain.study.test.interview;

/**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：
 * 153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 * 
 * @author brain
 *
 */
public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			if (isShuixianNum(i)) {
				System.out.println(i);
			}
		}
		
		System.out.println("方法2");

		// 方法2
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					int num = 100*i+10*j+k;
					if (i*i*i+j*j*j+k*k*k == num && num > 99) {
						System.out.println(num);
					}
				}
			}
		}
	}

	public static boolean isShuixianNum(int num) {
		if (num < 100 || num > 999) {
			return false;
		}
		int a0 = num % 10;
		int a1 = num / 10 % 10;
		int a2 = num / 100 % 10;
		return num == a0 * a0 * a0 + a1 * a1 * a1 + a2 * a2 * a2;
	}

	
	
}
