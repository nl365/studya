/**
 * 
 */
package com.brain.study.java7;

import java.io.IOException;

/**
 * java7异常处理改进 
(1)Throwable类增加addSuppressed方法和getSuppressed方法，支持原始异常中加入被抑制的异常。 
异常抑制：在try和finally中同时抛出异常时，finally中抛出的异常会在异常栈中向上传递，而try中产生的原始异常会消失。 
(2)catch子句可以同时捕获多个异常 
(3)try-with-resources语句 
Java7之前需要在finally中关闭socket、文件、数据库连接等资源； 
Java7中在try语句中申请资源，实现资源的自动释放（资源类必须实现java.lang.AutoCloseable接口，一般的文件、数据库连接等均已实现该接口，close方法将被自动调用）。 


 * @author brain
 *
 */
public class TestJava7Exception {

	public TestJava7Exception() {
		// TODO Auto-generated constructor stub
	}

	static class AutoClose implements AutoCloseable {
		public String name;

		public AutoClose(String name) {
			this.name = name;
		}

		@Override
		public void close() throws IOException { // 接口中定义抛出的异常时Exception
													// 子类不能抛出更多，需要在try后捕获活或抛出处理
			System.out.println(name + "close()");
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		try {
			testAutoCloseable();
		} catch (Throwable e) {
		}
	}

	public static void testAutoCloseable() throws Throwable {
		/**
		 * 输出： try auto 2 close() auto 1 close() catch finally
		 */
		/**
		 * 声明资源时要分析好资源关闭顺序,先声明的后关闭 在try-with-resource中也可以有catch与finally块
		 * 只是catch与finally块是在处理完try-with-resource后才会执行。
		 */
		try (AutoClose is1 = new AutoClose("auto 1"); AutoClose is2 = new AutoClose("auto 2")) {
			System.out.println("try");
			throw new RuntimeException("test exception");
		} catch (IOException | RuntimeException e) { // 使用'|'分割，多个类型，只有一个对象 异常类间不能有继承关系
			System.out.println("catch");
			Throwable throwable = new Exception("exception");
			throwable.addSuppressed(e);  // addSuppressed 支持原始异常中加入被抑制的异常
			throw throwable;
		} finally {
			System.out.println("finally");
		}
	}

	/**
	 * java 7 之前的写法
	 * 
	 * @throws IOException
	 */
	public static void try_catch_finally() {
		try {
			System.out.println("try");
			throw new RuntimeException("test exception");
		} catch (Exception e) {
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}
	}

	/**
	 * java 7 的写法
	 * 
	 * @throws IOException
	 */
	public static void try_with_resource() throws IOException {
		try (AutoClose is = new AutoClose("auto 3")) {
			System.out.println("try");
		}
	}
}
