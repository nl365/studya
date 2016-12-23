/**
 * 
 */
package com.brain.study.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * @author brain
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		// test4();
		test5();
		test6();
		test7();
//		test8();

	}

	public static void test1() {
		Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> sub) {
				sub.onNext("Hello, world!");
				sub.onCompleted();
			}
		});

		Subscriber<String> subscriber = new Subscriber<String>() {
			@Override
			public void onNext(String s) {
				System.out.println(s);
			}

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable e) {
			}
		};
		observable.subscribe(subscriber);
	}

	public static void test2() {
		Subscriber<String> subscriber = new Subscriber<String>() {
			@Override
			public void onNext(String s) {
				System.out.println(s);
			}

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable e) {
			}
		};
		// Observable.just就是用来创建只发出一个事件就结束的Observable对象，
		Observable.just("test2").subscribe(subscriber);
	}

	public static void test3() {
		// 简化Subscriber 并不关心OnComplete和OnError，
		// 我们只需要在onNext的时候做一些处理，这时候就可以使用Action1类。
		Observable.just("test3").subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				System.out.println(s);
			}
		});
	}

	public static void test4() {
		// subscribe方法有一个重载版本，接受三个Action1类型的参数，分别对应OnNext，OnComplete， OnError函数。
		// public final Subscription subscribe(final Action1<? super T> onNext,
		// final Action1<Throwable> onError,
		// final Action0 onCompleted);
		Observable.just("test4").subscribe(new Action1<String>() {

			@Override
			public void call(String s) {
				System.out.println("call 1 " + s);
			}

		}, new Action1<Throwable>() {

			@Override
			public void call(Throwable error) {
				System.out.println("call 2 " + error);
			}

		}, new Action0() {

			@Override
			public void call() {
				System.out.println("call 3 ");
			}

		});
	}

	public static void test5() {
		// 使用java8的lambda可以使代码更简洁
		Observable.just("test lambda")
				  .subscribe(s -> System.out.println(s));
	}

	// map操作符，就是用来把把一个事件转换为另一个事件的。
	// map()操作符就是用于变换Observable对象的，map操作符返回一个Observable对象，这样就可以实现链式调用，
	// 在一个Observable对象上多次使用map操作符，最终将最简洁的数据传递给Subscriber对象。
	public static void test6() {
		Observable.just("test map()")
		          .map(s -> s + " : map string to string ")
		          .subscribe(s -> System.out.println(s));
		
	}

	// map操作符更有趣的一点是它不必返回Observable对象返回的类型，你可以使用map操作符返回一个发出新的数据类型的observable对象。
	public static void test7() {
		Observable.just("test map() 变成另一个类型")
				  .map(s -> s.hashCode())
				  .subscribe(i -> System.out.println(Integer.toString(i)));
		
		Observable.just("test map() 变成另一个类型 两个map")
		  .map(s -> s.hashCode())
		  .map(i -> Integer.toString(i))
		  .subscribe(s -> System.out.println(s));
	}
	
	
//	just(T...): 将传入的参数依次发送出来。
//	from(T[]) / from(Iterable<? extends T>) : 将传入的数组或 Iterable 拆分成具体对象后，依次发送出来。
	public static void test10(String... names) {
		Observable.from(names).subscribe(new Action1<String>() {

			@Override
			public void call(String s) {
				System.out.println("Hello " + s + "!");
			}

		});
	}
	
	
//	observable.subscribe(observer);  或者： observable.subscribe(subscriber);
//	有人可能会注意到， subscribe() 这个方法有点怪：它看起来是『observalbe 订阅了 observer / subscriber』
//	而不是『observer / subscriber 订阅了 observalbe』，这看起来就像『杂志订阅了读者』一样颠倒了对象关系。
//	这让人读起来有点别扭，不过如果把 API 设计成 observer.subscribe(observable) / subscriber.subscribe(observable) ，
//	虽然更加符合思维逻辑，但对流式 API 的设计就造成影响了，比较起来明显是得不偿失的。
	
//	Observer 和 Subscriber 具有相同的角色，而且 Observer 在 subscribe() 过程中最终会被转换成 Subscriber 对象，
//	因此，从这里开始，后面的描述我将用 Subscriber 来代替 Observer ，这样更加严谨。
	
	
//	在 RxJava 的默认规则中，事件的发出和消费都是在同一个线程的。
//	也就是说，如果只用上面的方法，实现出来的只是一个同步的观察者模式。
//	观察者模式本身的目的就是『后台处理，前台回调』的异步机制，因此异步对于 RxJava 是至关重要的。
//	而要实现异步，则需要用到 RxJava 的另一个概念： Scheduler 。


}
