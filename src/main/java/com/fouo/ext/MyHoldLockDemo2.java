package com.fouo.ext;

import java.util.concurrent.TimeUnit;

class MyHoldLock implements Runnable {
    private String lockA;
    private String lockB;

    public MyHoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            try {
                System.out.println(Thread.currentThread().getName() + "  线程获取锁   " + lockA);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                try {
                    System.out.println(Thread.currentThread().getName() + "  线程获取锁   " + lockB);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 死锁demo
 *
 * @author fouo
 * @date 2020/10/30 16:28
 */
public class MyHoldLockDemo2 {
    public static void main(String[] args) {
        String lockA = "A锁";
        String lockB = "B锁";

        new Thread(
                new MyHoldLock(lockA, lockB), "AAA"
        ).start();

        new Thread(
                new MyHoldLock(lockB, lockA), "BBB"
        ).start();
    }
}
