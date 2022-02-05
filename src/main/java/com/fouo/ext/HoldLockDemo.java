package com.fouo.ext;

import java.util.concurrent.TimeUnit;

/**
 * 死锁Demo
 *
 * @author fouo
 * @date 2020/10/30 15:58
 */
class HoldLock implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            try {
                System.out.println(Thread.currentThread().getName() + "自己持有" + lockA + "尝试获取" + lockB);
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                try {
                    System.out.println(Thread.currentThread().getName() + "自己持有" + lockB + "尝试获取" + lockA);
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class HoldLockDemo {
    public static void main(String[] args) {
        String lockA = "LockA";
        String lockB = "LockB";

        new Thread(
                new HoldLock(lockA,lockB), "A"
        ).start();

        new Thread(
                new HoldLock(lockB,lockA), "B"
        ).start();
    }
}
