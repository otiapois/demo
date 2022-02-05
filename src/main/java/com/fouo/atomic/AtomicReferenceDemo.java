package com.fouo.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * 原子Integer
 *
 * @author fouo
 * @date 2021/10/27 20:28
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicMarkableReference<Object> markableReference = new AtomicMarkableReference<>(100, false);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        //启动50个线程
        new Thread(() -> {
            boolean marked = markableReference.isMarked();
            System.out.println(Thread.currentThread().getName() + "\t 1次版本号" + marked);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            markableReference.compareAndSet(100, 101, marked, !marked);
            System.out.println(markableReference.getReference());
            countDownLatch.countDown();
        }, "t5").start();

        new Thread(() -> {
            boolean marked = markableReference.isMarked();
            System.out.println(Thread.currentThread().getName() + "\t 1次版本号" + marked);
            //暂停几秒钟线程
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            markableReference.compareAndSet(100, 2020, marked, !marked);
            System.out.println(markableReference.getReference());
            countDownLatch.countDown();
        }, "t6").start();
        countDownLatch.await();
        System.out.println(markableReference.getReference());



    }
}
