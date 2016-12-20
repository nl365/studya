package com.brain.study.concurrency.sync_reentrantreadwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {  
    private int price1;  
    private int price2;  
    private ReadWriteLock rwLock = null;  
  
    public PricesInfo() {  
        price1 = 1;  
        price2 = 2;  
        rwLock = new ReentrantReadWriteLock();  
    }  
  
    public int getPrice1() {  
        rwLock.readLock().lock();  
        System.out.println(Thread.currentThread().getName()  
                + "get start price1");  
        int temp = price1;  
        try {  
            Thread.sleep(100);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }         
        System.out.println(Thread.currentThread().getName()  
                + "get end price1=" + price1);  
        rwLock.readLock().unlock();  
        return temp;  
    }  
  
    public int getPrice2() {  
        rwLock.readLock().lock();  
        System.out.println(Thread.currentThread().getName()  
                + "get start price2");    
        int temp = price2;  
        try {  
            Thread.sleep(100);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(Thread.currentThread().getName()  
                + "get end price2=" + price2);  
        rwLock.readLock().unlock();  
        return temp;  
    }  
     
    /**
     * 写入时候同时写入price1和price2
     * @param p1
     * @param p2
     */
    public void setPrices(int p1, int p2) {  
        rwLock.writeLock().lock();  
        System.out.println(Thread.currentThread().getName() + " set prices start");  
        price1 = p1;  
        price2 = p2;  
        System.out.println(Thread.currentThread().getName() + " set price1=" + price1 + "  price2=" + price2);  
        try {  
            Thread.sleep(100);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(Thread.currentThread().getName() + " set prices end");  
        rwLock.writeLock().unlock();  
    }  
      
    /**
     * reader
     * @author brain
     *
     */
    static class Reader implements Runnable {  
  
        private PricesInfo prices;  
  
        public Reader(PricesInfo prices) {  
            this.prices = prices;  
        }  
  
        @Override  
        public void run() {  
            for (int i = 0; i < 10; i++) {  
                prices.getPrice1();  
                prices.getPrice2();  
            }  
        }  
    }  
    
    
    /**
     * writer
     * @author brain
     *
     */
    static class Writer implements Runnable {  
  
        private PricesInfo prices;  
  
        public Writer(PricesInfo prices) {  
            this.prices = prices;  
        }  
  
        @Override  
        public void run() {  
            for (int i = 0; i < 3; i++) {  
                this.prices.setPrices((int)(Math.random() * 10),(int)(Math.random() * 10));  
            }  
              
            try {  
                Thread.sleep(100);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    
    
  
    public static void main(String[] args) {  
        PricesInfo prices = new PricesInfo();  
          
        for (int i = 0; i < 10; i++) {  
            new Thread(new Reader(prices)).start();  
        }  
        for (int i = 0; i < 2; i++) {  
            new Thread(new Writer(prices)).start();  
        }  
    }  
}  