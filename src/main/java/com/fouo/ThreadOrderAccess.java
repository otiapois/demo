package com.fouo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间实现顺序调用
 * 实现a->b->c
 * 三个线程启动，要求如下：
 * <p>
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ...来10轮
 *
 * @author fouo
 * @date 2020/10/16 21:09
 */
class ThreadAccessDemo {
    private Lock lock = new ReentrantLock();
    private Condition aCondition = lock.newCondition();
    private Condition bCondition = lock.newCondition();
    private Condition cCondition = lock.newCondition();

    private int number = 1;

    public void printA() {
        lock.lock();
        try {
            while (number != 1) {
                aCondition.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "AA:" + i);
            }
            number = 2;
            bCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {

        lock.lock();
        try {
            while (number != 2) {
                bCondition.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "BB:" + i);
            }
            number = 3;
            cCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {

        lock.lock();
        try {
            while (number != 3) {
                cCondition.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "CC:" + i);
            }
            number = 1;
            aCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class ThreadOrderAccess {
    public static void main(String[] args) {
        ThreadAccessDemo demo = new ThreadAccessDemo();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.printA();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.printB();
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.printC();
            }
        }, "c").start();

    }
}
