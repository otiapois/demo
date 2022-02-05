package com.fouo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 *
 * @author fouo
 * @date 2020/11/2 14:27
 */
public class ReentrantLockDemo {
    static Object o1 = new Object();

    public static void t1(){

        synchronized (o1){
            System.out.println(1);
            synchronized (o1){
                System.out.println(2);
                synchronized (o1){
                    System.out.println(3);
                }
            }
        }
    }
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        t1();
    }
}
