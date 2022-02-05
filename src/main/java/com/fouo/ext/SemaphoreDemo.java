package com.fouo.ext;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号灯Demo
 *
 * @author fouo
 * @date 2020/10/29 18:09
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);

        for (int i = 0; i < 6; i++) {
            new Thread(
                    ()->{
                        try {
                            semaphore.acquire();
                            System.out.println(Thread.currentThread().getName()+"  抢到！");
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            System.out.println(Thread.currentThread().getName()+"  释放~");
                            semaphore.release();
                        }
                    },String.valueOf(i)
            ).start();
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }
}
