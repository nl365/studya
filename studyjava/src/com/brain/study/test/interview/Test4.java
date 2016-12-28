/**
 * 
 */
package com.brain.study.test.interview;

/**
 * 将一个正整数分解质因数
 * 
 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成： (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * (2)如果n>=k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。
 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 * 
 * @author brain
 *
 */
public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 6;
		primeFactor(num);
		System.out.println(num + "完数"+ isPerfectNumber(num));
	}

	public static void primeFactor(int num) {
		int n = num;
		int k = 2;
		while (true) {
			if (k < n) {
				if (n % k == 0) {
					System.out.print(k);
					System.out.print("*");
					n = n / k;
				} else {
					k++;
				}
			} else {
				System.out.println(k);
				break;
			}
		}
	}

	
	public static boolean isPerfectNumber(int num) {
		int n = num;
		int k = 2;
		int sum = 0;
		while (true) {
			if (k < n) {
				if (n % k == 0) {
					sum += k;
					n = n / k;
				} else {
					k++;
				}
			} else {
				sum += k;
				break;
			}
		}
		
		return sum + 1 == num;
	}

}
