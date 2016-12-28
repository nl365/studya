/**
 * 
 */
package com.brain.study.test.interview;

/**
 * @author brain
 *
 */
public class FindAlone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findAlone("aa"));
		System.out.println(findAlone("aab"));
		System.out.println(findAlone("baa"));
		System.out.println(findAlone("baa"));
		System.out.println(findAlone("ddcbaa"));
		System.out.println(findAlone(""));
		System.out.println(findAlone(null));

	}
	
	/**
	 * 返回字符串中第一个只出现一次的字符
	 * @param in 字符串，null会抛出IllegalArgumentException
	 * @return 字符串中第一个只出现一次的字符，没有返回'\0'
	 */
	public static char findAlone(String in) {
		if (in == null) {
			throw new IllegalArgumentException("in is null");
		}
		
		char[] array = in.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char ch = array[i];
			int j = 0;
			for (; j < array.length; j++) {
				if (ch == array[j] && i != j) {
					break;
				}
			}
			if(j == array.length) {
				return ch;
			}
		}

		return '\0';
	}
}
