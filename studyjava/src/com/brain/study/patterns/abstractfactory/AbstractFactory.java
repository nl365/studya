/**
 * 
 */
package com.brain.study.patterns.abstractfactory;

/**
 * AbstractFactory
 * 提供一个创建一系列相关对象或相互依赖的对象的接口
 * 
 * @author Brain
 * @date 2014-12-8
 */
public interface AbstractFactory {
	AbstractProductA createProductA();

	AbstractProductB createProductB();
}
