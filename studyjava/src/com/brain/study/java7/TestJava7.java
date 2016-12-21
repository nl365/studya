/**
 * 
 */
package com.brain.study.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author brain
 *
 */
public class TestJava7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 这个<>被叫做diamond（钻石）运算符，Java 7后这个运算符从引用的声明中推断类型
		Map<String, List<String>> myMap = new HashMap<>(); // 注意后面的"<>"
		List<String> list = new ArrayList<>();
		myMap.put("L1", list);

		// 很长的数字可读性不好，在Java 7中可以使用下划线分隔长int以及long了。
		int one_million = 1_000_000;
		System.out.println(one_million);
		long longValue = 1_000_000_000;
		System.out.println(longValue);

		/**
		 * 编译器在编译时先做处理： 1.case只有一种情况，直接转成if；
		 * 2.如果只有一个case和default，则直接转换为if...else...；
		 * 3.有多个case，先将String转换为hashCode，然后对应的进行处理，JavaCode在底层兼容Java7以前版本。
		 */
		String key = "KEY_CASE_1";
		switch (key) {
		case "KEY_CASE_1":
			System.out.println("string switch case ");
			break;

		default:
			break;
		}

		//
		int binary = 0b1111_1111;
		System.out.println(binary);
		byte aByte = 0b001;
		short aShort = (short) 0b010;
		System.out.println(aByte);
		System.out.println(aShort);

		// 当参数为不可具体化的类型时，如List，编译器将产生警告，需要使用@SuppressWarnings("unchecked")注解声明；
		// Java7中使用@SafeVarargs注解抑制编译器警告。
		useVarargs(new ArrayList<String>());
	}

	@SafeVarargs
	public static <T> T useVarargs(T... args) {
		return args.length > 0 ? args[0] : null;
	}

}
