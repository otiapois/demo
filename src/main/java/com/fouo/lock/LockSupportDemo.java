package com.fouo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.DeflaterOutputStream;

/**
 * @author fouo
 * @date 2020/11/2 17:50
 */
public class LockSupportDemo {
    public static void main(String[] args) {
    ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"----------come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //使线程阻塞，等待唤醒
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"----------被唤醒");

        }, "A");
        Thread b = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"----------come in");
            //使线程阻塞，等待唤醒
            LockSupport.unpark(a);
            System.out.println("B结束 ");
        }, "B");
        a.start();
        b.start();
    }
}
