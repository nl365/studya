/**
 * 
 */
package com.brain.study.patterns.builder2;

/**
 * Builder
 * 将getResult放到接口中更加合理，同事buildXXX方法返回Builder本身，可以形成链式方法调用
 * @author Brain
 * @date 2014-12-7
 */
public interface Builder {

	public Builder buildPartA();

	public Builder buildPartB();

	public Builder appendPart(Object obj);

	public Product getResult();
}
