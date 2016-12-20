/**
 * 
 */
package com.brain.study.concurrency.threadinterrupted;

/**
 * @author brain
 *
 */
public class MyRunnable implements Runnable {  
	  
    private int i = 0;  
  
    @Override  
    public void run() {  
        while (true) {  
            if (Thread.currentThread().isInterrupted()) {  
                System.out.println(Thread.currentThread().getName()  
                        + "isInterrupted true");  
                return;  
            } else {  
                System.out.println(Thread.currentThread().getName() + "   "  
                        + (i++));  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        Thread thread = new Thread(new MyRunnable());  
        thread.start();  
        try {  
            Thread.sleep(50);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        thread.interrupt();  
    }  
}  