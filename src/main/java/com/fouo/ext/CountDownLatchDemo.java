package com.fouo.ext;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 演示
 *
 * @author fouo
 * @date 2020/10/29 17:07
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);


        for (int i=0;i<5;i++){
            new Thread(
                    ()->{
                        System.out.println(Thread.currentThread().getName()+"   执行完毕");
                        countDownLatch.countDown();
                    },CountryEnum.forEachCountryName(i).getRetName()
            ).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"   执行完毕");
    }
}
