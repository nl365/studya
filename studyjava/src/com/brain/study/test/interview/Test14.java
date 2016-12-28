/**
 * 
 */
package com.brain.study.test.interview;

/**
 * 输入某年某月某日，判断这一天是这一年的第几天？
 * 
 * @author brain
 *
 */

public class Test14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(dayOfDate(2001, 2, 28));
	}

	public static int dayOfDate(int year, int month, int day) {
		if (month < 0 || day < 0) {
			return -1;
		}
		int[] dayOfMonthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeap(year)) {
			dayOfMonthArray[1] = 29;
		} else {
			dayOfMonthArray[1] = 28;
		}
		int m = month - 1;
		int sum = 0;
		for (int i = 0; i < m; i++) {
			sum += dayOfMonthArray[i];
		}
		if (day > dayOfMonthArray[m]) {
			return -1;
		} else {
			sum += day;
		}
		return sum;
		
	}

	private static boolean isLeap(int year) {
		return (year % 4 == 0  && year % 100 != 0) || year % 400 == 0;
	}

}
