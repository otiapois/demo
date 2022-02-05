package com.fouo.ext;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.CheckedOutputStream;

/**
 * 自旋锁实例
 *
 * @author fouo
 * @date 2020/10/29 15:11
 */
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "come in");
        while (!threadAtomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        threadAtomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "out");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(
                () -> {
                    spinLockDemo.myLock();
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println(Thread.currentThread().getName() + "线程被锁上了");
                        spinLockDemo.myUnLock();
                        System.out.println(Thread.currentThread().getName() + "线程解锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, "A"
        ).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(
                () -> {
                    spinLockDemo.myLock();
                    System.out.println(Thread.currentThread().getName() + "线程被锁上了");
                    spinLockDemo.myUnLock();
                    System.out.println(Thread.currentThread().getName() + "线程解锁");
                }, "B"
        ).start();


    }
}
