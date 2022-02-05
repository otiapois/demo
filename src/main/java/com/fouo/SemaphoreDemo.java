package com.fouo;

import java.util.concurrent.Semaphore;

/**
 * @author fouo
 * @date 2020/10/19 22:21
 */
public class SemaphoreDemo {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);

        for (int i=0;i<7;i++){
            new Thread(()->{

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },""+i).start();
        }
    }
}
