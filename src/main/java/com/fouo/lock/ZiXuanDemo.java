package com.fouo.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/**
 * 自旋锁实现方式 通过原子引用
 *
 * @author fouo
 * @date 2021/10/26 23:23
 */
public class ZiXuanDemo {

    public static void main(String[] args) throws InterruptedException {
        MyLock myLock = new MyLock();
        new Thread(()->{
            System.out.println("A");
            myLock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLock.unLock();
        },"A").start();

        new Thread(()->{
            System.out.println("B");
            myLock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLock.unLock();
        },"b").start();


        TimeUnit.SECONDS.sleep(5);
    }
}

class MyLock{
    //创建一个原子引用
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)){

        }
    }
    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null );
    }

}
