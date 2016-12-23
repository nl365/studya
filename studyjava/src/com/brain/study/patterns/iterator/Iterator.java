/**
 * 
 */
package com.brain.study.patterns.iterator;

/**
 * Iterator
 * 提供一种统一的顺序访问集合中各个元素是方式，使得不暴露集合的内部表示
 * @author Brain
 * @date 2014-12-8
 */
public interface Iterator<T> {
	T next();

	boolean hasNext();
}
