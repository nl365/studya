/**
 * 
 */
package com.brain.study.test.interview;

/**
 * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 * 
 * @author brain
 *
 */
public class Test7 {
	public static void main(String[] args) {
		int letterCount = 0;
		int numberCount = 0;
		int spaceCount = 0;
		int otherCount = 0;

		String data = "abc11 \t\n\0";

		char[] array = data.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (Character.isLetter(array[i])) {
				letterCount++;
			} else if (Character.isDigit(array[i])) {
				numberCount++;
			} else if (Character.isSpaceChar(array[i])) {
				spaceCount++;
			} else {
				otherCount++;
			}
		}
		
		System.out.println("letterCount="+letterCount + "\nnumberCount="+numberCount
				+ "\nspaceCount="+spaceCount + "\notherCount="+otherCount );
	}

}
