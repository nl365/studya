/**
 * 
 */
package com.brain.study.concurrency.thread1;

/**
 * @author brain
 *
 */
public class Main {

	 /** 
	  * 关注构造方法
     * @param args 
     */  
    public static void main(String[] args) {  
        new Thread(new Calculator()).start();  
        new Thread(new Calculator()).start();  
        new Thread(new Calculator()).start();  
        new Thread(new Calculator()).start();  
    }  

}
