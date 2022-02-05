package com.fouo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author fouo
 * @date 2020/10/19 22:09
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("aaaaa");
        });
        for (int i = 1; i <= 7; i++) {
            int index = i;
            new Thread(
                    () -> {
                        try {
                            System.out.println("这是第" + index + "个线程");
                            cyclicBarrier.await();
                        } catch (InterruptedException e) {
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }


            ).start();

        }

    }
}
