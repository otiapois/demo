package com.fouo.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子Integer
 *
 * @author fouo
 * @date 2021/10/27 20:28
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        //启动50个线程
        CountDownLatch countDownLatch = new CountDownLatch(50);
        int numer = 50;
        MyNumber myNumber = new MyNumber();
        for (int i=0;i<50;i++){
            new Thread(
                    () -> {
                        for(int j=0;j<1000;j++){
                            myNumber.add();
                        }
                        countDownLatch.countDown();
                    }
            ).start();
        }

//        TimeUnit.SECONDS.sleep(2);   这是一种能全部打印出来的方式      但是时间不可控制
        countDownLatch.await();
        System.out.println(myNumber.get());
    }
}

class MyNumber {
    AtomicInteger integer = new AtomicInteger(0);

    public void add() {
        integer.incrementAndGet();
    }
    public int get() {
        return integer.get();
    }

}