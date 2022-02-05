package com.fouo.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptDemo2 {
    public static void main(String[] args) throws InterruptedException {


        Thread a = new Thread(
                () -> {
                   synchronized (InterruptDemo2.class){
                    try {
                        System.out.println(Thread.currentThread().getName() + "---线程启动----" + Thread.currentThread().isInterrupted());
                        Thread.currentThread().wait();
                        System.out.println(Thread.currentThread().getName() + "---线程启动----" + Thread.currentThread().isInterrupted());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                    }
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
