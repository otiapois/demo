package com.fouo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程8锁
 *
 *
 * @author fouo
 * @date 2020/10/16 22:25
 */
class Phone {
    private ReentrantLock lock = new ReentrantLock();

    public synchronized void sendEmail() throws InterruptedException {
        try {
//            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----------sendEmail");
    }

    public synchronized void sendSMS() throws InterruptedException {
        System.out.println("-----------sendSMS");
    }

    public void sayHello() throws InterruptedException {
        System.out.println("-----------sayHello");
    }

    public void outer() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("-----------outer");
            inner();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            lock.unlock();
        }

    }
    public void inner() throws InterruptedException {
        System.out.println("-----------inner");
    }
}

public class Lock8 {
    public static void main(String[] args) {
        /*Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone1.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                phone1.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();*/

        Phone phone = new Phone();
        new Thread(
                ()->{
                    try {
                        phone.outer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"A"
        ).start();
        new Thread(
                ()->{
                    try {
                        phone.outer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"B"
        ).start();
    }
}
