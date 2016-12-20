package com.bystudio.studyandroid;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //============================
        /**[001]ThreadLocal

            * (0)ThreadLocal作用

            * (1)ThreadLocal原理
            ThreadLocal原理每个Thread持有一个ThreadLocalMap，当第一次调用ThreadLocal对象的get()
            方法的时候，会回调initialValue()得到初始化值，然后判断map是否存在 若不存在就创建ThreadLocalMap对象，赋值给thread对象的threadLocals属性，并将值put到threadLocals这个map中，key是ThreadLocal对象的引用，值是该对象的初始值。每个Thread可以有多个ThreadLocal对象都放在ThreadLocalMap中，每个ThreadLocal对象第一次调用get()时都会回调自己的initialValue()获得初始值放到map中.
               (线程的第一个ThreadLocal对象get()的时候会创建map,赋值给线程对象持有map引用)
               设计模式的享元模式的典型应用。

            * (2)Android SDK中 {@link ThreadLocal.Values}的实现原理？

            * (3)JDK中{@link ThreadLocalMap}的实现方式

            */
        class TestThreadLocal extends Thread {
            ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>(){
                @Override
                protected Integer initialValue() {
                return 100;
                }
            };

            @Override
            public void run() {
                Integer count = integerThreadLocal.get();
                count--;
                Log.d("ThreadLocal" , "current thread:" + Thread.currentThread()
                        + " count=" + count);
            }

        };

        Thread threadA = new TestThreadLocal();
        Thread threadB = new TestThreadLocal();

        threadA.start();
        threadB.start();


        /**[002]Handler Massage MassageQueue Looper
         *
         */

        /**[003]Android的线程机制
         *
         */
        Handler handler = new Handler();
        Looper.prepare();

        /**[004]ActivityThread
         */

        /**[005]非UI线程中访问UI线程的其他方式
         *


         /**[006]AsyncTask HandlerThread和IntentService
         *
         */

        /**[007]Java线程和线程池
         *
         * 深入join-fork
         *
         */

        //============================

        /**[008]Activity启动过程
         *
         */
        /**[009]Activity launch mode
         *
         */

        /**[010]ActivityStack Task
         *
         */

        /**[011]Intent 和 IntentFilter
         *
         */

        /**[012]
         *
         */

        /**[]AppCompatActivity和Activity的区别
         *
         */
    }
}
