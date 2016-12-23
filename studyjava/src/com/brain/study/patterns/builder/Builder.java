/**
 * 
 */
package com.brain.study.patterns.builder;

/**
 * Builder
 * 将一个复杂对象的创建和它的表示相分离，使得同样的创建过程可以创建不同的表示
 * @author Brain
 * @date 2014-12-7
 */
public abstract class Builder {

	public abstract void buildPartA();

	public abstract void buildPartB();

}
