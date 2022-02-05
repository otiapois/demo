package com.fouo.ext;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class MySpinLockDemo {

    private AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();

    public void myLock() {
        //获取进入该方法的当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "   come in");

        while (!threadAtomicReference.compareAndSet(null, thread)) {

        }

    }

    public void myUnLock() {
        //获取进入该方法的当前线程
        Thread thread = Thread.currentThread();
        threadAtomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {

        MySpinLockDemo mySpinLockDemo = new MySpinLockDemo();
        new Thread(
                () -> {
                    mySpinLockDemo.myLock();
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("A线程被锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        System.out.println("A线程锁释放");
                        mySpinLockDemo.myUnLock();
                    }
                },"A"
        ).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(
                () -> {
                    mySpinLockDemo.myLock();
                    try {
                        System.out.println("B线程被锁");
                    } finally {
                        System.out.println("B线程锁释放");
                        mySpinLockDemo.myUnLock();
                    }
                },"B"
        ).start();
    }
}
