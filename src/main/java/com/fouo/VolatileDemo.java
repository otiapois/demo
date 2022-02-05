package com.fouo;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public /*synchronized*/ void test() {
        this.num = 60;


    }

    public /*synchronized*/ void add() {
        num++;
    }

    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}

public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(
                    () -> {
                        for (int n = 1; n <= 500; n++) {
                            myData.add();
                            myData.addMyAtomic();
                        }
                        System.out.println(Thread.currentThread().getName() + "   " + myData.num);

                        System.out.println(Thread.currentThread().getName() + "   " + myData.atomicInteger);
                    }, "A"
            ).start();
        }

//        new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//                myData.test();
//                System.out.println(myData.num);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();


//        while (myData.num == 0) {
//
//
//        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "   " + myData.num);
    }
}
