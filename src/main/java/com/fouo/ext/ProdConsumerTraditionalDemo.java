package com.fouo.ext;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模式传统
 * <p>
 * 两线程一个消费+1 一个生产-1  交替进行5轮
 *
 * @author fouo
 * @date 2020/10/30 9:24
 */
class ShareData {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private int number = 0;

    //增加
    public void increament() {
        lock.lock();
        try {
            while (number != 0) {
                condition1.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "  生产者生产了===》 剩余" + number + "个");
            condition2.signalAll();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    //减少
    public void decreament() {
        lock.lock();
        try {
            while (number == 0) {
                condition2.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "  消费者消费了===》 剩余" + number + "个");
            condition1.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


}

public class ProdConsumerTraditionalDemo {
    public static void main(String[] args) {

        ShareData shareData = new ShareData();
        new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        shareData.increament();
                    }
                },"A"
        ).start();
        new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        shareData.increament();
                    }
                },"C"
        ).start();

        new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        shareData.decreament();
                    }
                },"B"
        ).start();
        new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        shareData.decreament();
                    }
                },"D"
        ).start();

    }
}
