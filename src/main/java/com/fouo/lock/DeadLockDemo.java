package com.fouo.lock;


public class DeadLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();

        new Thread(()->{
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName()+"-->lockA");
                synchronized (lockB){
                    System.out.println(Thread.currentThread().getName()+"-->lockB");
                }
            }
        },"A").start();
        new Thread(()->{
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"-->lockA");
                synchronized (lockA){
                    System.out.println(Thread.currentThread().getName()+"-->lockB");
                }
            }
        },"B").start();
    }
}
