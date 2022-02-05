package com.fouo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * 50个线程每个线程100W个数
 *
 * @author fouo
 * @date 2021/10/30 13:14
 */
public class LongAddrDemo {
    public static void main(String[] args) throws InterruptedException {
        MyClick myClick = new MyClick();
        CountDownLatch countDownLatch = new CountDownLatch(50);
        CountDownLatch countDownLatch2 = new CountDownLatch(50);
        CountDownLatch countDownLatch3 = new CountDownLatch(50);
        CountDownLatch countDownLatch4 = new CountDownLatch(50);
        long s = System.currentTimeMillis();
        for (int i=0;i<50;i++){
            new Thread(()->{
                for(int j=0;j<1000000;j++){
                    myClick.synAddClick();
                }
                countDownLatch.countDown();
            },i+"").start();
        }
        countDownLatch.await();
        long e = System.currentTimeMillis();
        myClick.synGet();
        System.out.println(e-s);



        //使用原子类
        long s1 = System.currentTimeMillis();
        for (int i=0;i<50;i++){
            new Thread(()->{
                for(int j=0;j<1000000;j++){
                    myClick.atomicAddClick();
                }
                countDownLatch2.countDown();
            },i+"").start();
        }
        countDownLatch2.await();
        long e1 = System.currentTimeMillis();
        myClick.atomicGet();
        System.out.println(e1-s1);




        //使用原子类
        long s2 = System.currentTimeMillis();
        for (int i=0;i<50;i++){
            new Thread(()->{
                for(int j=0;j<1000000;j++){
                    myClick.longClick();
                }
                countDownLatch3.countDown();
            },i+"").start();
        }
        countDownLatch3.await();
        long e2 = System.currentTimeMillis();
        myClick.longGet();
        System.out.println(e2-s2);



        //使用原子类
        long s3 = System.currentTimeMillis();
        for (int i=0;i<50;i++){
            new Thread(()->{
                for(int j=0;j<1000000;j++){
                    myClick.accuClick();
                }
                countDownLatch4.countDown();
            },i+"").start();
        }
        countDownLatch4.await();
        long e3 = System.currentTimeMillis();
        myClick.accuGet();
        System.out.println(e3-s3);
    }
}

class MyClick{
    int i =0;
    AtomicLong a =new AtomicLong(0);
    LongAccumulator ac = new LongAccumulator((x,y)->{
        return x+y;
    }, 0);

    LongAdder l = new LongAdder();
    public synchronized void synAddClick(){
        i++;
    }
    public  void synGet(){
        System.out.println(i);
    }

    public void atomicAddClick(){
        a.incrementAndGet();
    }
    public void atomicGet(){
        System.out.println(a.get());
    }
    public void longClick(){
        l.increment();
    }
    public void longGet(){
        System.out.println( l.intValue());
    }

    public void accuClick(){
        ac.accumulate(1);
    }
    public void accuGet(){
        System.out.println( ac.get());
    }
}
