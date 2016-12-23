/**
 * 
 */
package com.brain.study.patterns.command;

/**
 * Command
 * 将一个请求封装成一个对象，可以用不同的请求来对客户进行参数化，也可以对请求进行排队、判重、记录日志、cancel等操作
 * @author Brain
 * @date 2014-12-8
 */
public interface Command {
	void execute();
}
