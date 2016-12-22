package com.brain.study.collection.identityhashmap;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person per = (Person) obj;
		if (this.name.equals(per.name) && this.age == per.age) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() * this.age;
	}

	@Override
	public String toString() {
		return "姓名：" + this.name + "；年龄：" + this.age;
	}
};

/**
 * IdentityHashMap 有一种key值可以重复的map
 * 
 * @author brain
 */
public class IdentityHashMapDemo {
	public static void main(String args[]) {
		Map<Person, String> map = new IdentityHashMap<Person, String>();
		
		map.put(new Person("张三", 30), "zhangsan_1");
		map.put(new Person("张三", 30), "zhangsan_2");
		
		// 如果是同一个引用，则不能重复
		// Person person = new Person("张三", 30);
		// map.put(person, "zhangsan_1");
		// map.put(person, "zhangsan_2"); 	// 如果用这两个 则不会重复存在map中
		
		map.put(new Person("李四", 31), "lisi");

		// 使用Set接收全部内容
		Set<Map.Entry<Person, String>> allSet = map.entrySet();
		
		// 迭代输出
		Iterator<Map.Entry<Person, String>> iter = allSet.iterator();
		while (iter.hasNext()) {
			Map.Entry<Person, String> entry = iter.next();
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}
};
