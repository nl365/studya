/**
 * 
 */
package com.brain.study.java7.autoclose;

import java.io.IOException;

/**
 * @author brain
 *
 */
public class TestTryWithResource {

	public TestTryWithResource() {
		// TODO Auto-generated constructor stub
	}

	static class AutoClose implements AutoCloseable {
		public String name;

		public AutoClose(String name) {
			this.name = name;
		}

		@Override
		public void close() throws IOException { 	// 接口中定义抛出的异常时Exception
													// 子类不能抛出更多，需要在try后捕获活或抛出处理
			System.out.println(name + "close()");
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		testAutoCloseable();
	}

	public static void testAutoCloseable() {
		/**
		 * 输出： 
		 * try 
		 * auto 2 close() 
		 * auto 1 close() 
		 * catch 
		 * finally
		 */
		/**
		 * 声明资源时要分析好资源关闭顺序,先声明的后关闭 在try-with-resource中也可以有catch与finally块
		 * 只是catch与finally块是在处理完try-with-resource后才会执行。
		 */
		try (AutoClose is1 = new AutoClose("auto 1"); AutoClose is2 = new AutoClose("auto 2")) {
			System.out.println("try");
			throw new RuntimeException("test exception");
		} catch (Exception e) {
			System.out.println("catch");
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
