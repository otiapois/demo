package com.fouo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditioner {

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    private int number = 0;

    public void add() {
        lock.lock();
        try {
            while (number != 0) {
                condition1.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition2.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void minus() {
        lock.lock();
        try {
            while (number == 0) {
                condition2.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition1.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
   /* public synchronized void add() {
        try {
            while(number!=0){
                this.wait();
            }
            ++number;
            System.out.println(Thread.currentThread().getName()+":"+number);
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

    public synchronized void minus() {

        try {
            while(number == 0){
                this.wait();
            }
            --number;
            System.out.println(Thread.currentThread().getName()+":"+number);
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }*/
}

/**
 * 题目：现在两个线程，可以操作初始化值作为零的一个变量
 * 实现一个线程对该变量加1，一个线程对该变量减1
 * 实现交替 10轮 变量初始值为0
 *
 * @author fouo
 * @date 2020/10/16 13:50
 */
public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirConditioner air = new AirConditioner();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.add();
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.minus();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.add();
            }

        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.minus();
            }
        }, "D").start();
    }
}
