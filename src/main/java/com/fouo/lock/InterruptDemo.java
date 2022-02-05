package com.fouo.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread a = new Thread(
                () -> {
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + "---线程启动----" + Thread.currentThread().isInterrupted());
                        condition.await();
                        System.out.println(Thread.currentThread().getName() + "---线程启动----" + Thread.currentThread().isInterrupted());
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }, "A"
        );
        a.start();


        TimeUnit.SECONDS.sleep(5);

        a.interrupt();
        System.out.println(Thread.currentThread().getName()+"-------"+a.isInterrupted());

        TimeUnit.SECONDS.sleep(50);
        System.out.println(Thread.currentThread().getName()+"-------"+Thread.currentThread().isInterrupted());


    }
}
