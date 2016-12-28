/**
 * 
 */
package com.brain.study.test.interview;

/**
 * 题目：判断101-200之间有多少个素数，并输出所有素数。 分析：素数是只有自己和1两个因数
 * 
 * @author brain
 *
 */
public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		for (int i = 101; i < 200; i++) {
			if(isPrime(i)) {
				count++;
				System.out.println(i);
			}
		}
		
		System.out.println("共：" + count);
	}

	public static boolean isPrime(int num) {
		int i = 2;
		for (; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		if (i == num) {
			return true;
		}
		
		return false;
	}
}
