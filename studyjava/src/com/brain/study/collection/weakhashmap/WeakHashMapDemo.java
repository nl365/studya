package com.brain.study.collection.weakhashmap;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
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
		return "name:" + this.name + "；age：" + this.age;
	}
};

/**
 * WeakHashMap.Entry内部类 继承自WeakReference 实现Map.Entry<K,V>
   private static class Entry<K,V> extends WeakReference<Object> implements Map.Entry<K,V> {
 * @author brain
 */
public class WeakHashMapDemo {
	public static void main(String args[]) {
		Map<Person, String> map = new WeakHashMap<Person, String>();
		map.put(new Person("张三", 30), "zhangsan_1");
		map.put(new Person("张三", 30), "zhangsan_2");
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
