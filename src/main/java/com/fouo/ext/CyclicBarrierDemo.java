package com.fouo.ext;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环屏障
 *
 * @author fouo
 * @date 2020/10/29 17:41
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()->{
            System.out.println("??");

        });
        for (int i=0;i<5;i++){
            new Thread(
                    ()->{

                        System.out.println(Thread.currentThread().getName()+"   执行完毕");
                        try {
                            cyclicBarrier.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    },CountryEnum.forEachCountryName(i).getRetName()
            ).start();
        }



    }
}
