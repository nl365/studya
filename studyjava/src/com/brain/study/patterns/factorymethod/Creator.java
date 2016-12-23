package com.brain.study.patterns.factorymethod;

/**
 * Creator
 * 定义一个创建对象的接口，让子类去决定创建的具体的类，将对象创建延迟到子类
 * 基于接口编程的基类是稳定的
 * @author Brain
 * @date 2014-12-8
 */
public interface Creator {
	Product createProduct();
}
