package com.fouo;

/**
 * 多线程模板套路+模板
 * <p>
 * 在高内聚低耦合的前提小,多线程   操作   资源类
 * 判断 / 干活 /通知
 * 多线程交互中，必须要防止多线程的虚假唤醒，也即判断只能用while 不能用if
 *
 * @author fouo
 * @date 2020/10/16 10:44
 */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 * 被调用的资源类没有继承或者实现任何接口0污染
 */
class Ticket {
    private Lock lock = new ReentrantLock();
    private int number = 30;

    int temp = 0;

    public void saleTicket() {
        lock.lock();
        try {
            if (number > 0) {
                temp++;
                number--;
                System.out.println(Thread.currentThread().getName() + "\t卖了：" + (temp) + "\t还剩下：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

       /* //线程 demo1
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "fouo-thread-demo1").start();


        //线程 demo2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "fouo-thread-demo2").start();

        //线程 demo3
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "fouo-thread-demo3").start();*/
        new  Thread(()->{
            for (int i = 1; i <= 40; i++) {
                ticket.saleTicket();
            }
        },"fouo-thread-demo1").start();

        new  Thread(()->{
            for (int i = 1; i <= 40; i++) {
                ticket.saleTicket();
            }
        },"fouo-thread-demo2").start();

       new  Thread(()->{
           for (int i = 1; i <= 40; i++) {
               ticket.saleTicket();
           }
       },"fouo-thread-demo3").start();

    }
}
