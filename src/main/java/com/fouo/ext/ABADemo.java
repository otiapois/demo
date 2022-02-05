package com.fouo.ext;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA 问题的解决方案
 *
 * @author fouo
 * @date 2020/10/28 20:35
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(150, 1);
    public static void main(String[] args) {

//        new Thread(
//                () -> {
//                    atomicReference.compareAndSet(100, 120);
//                    System.out.println(Thread.currentThread().getName()+" "+atomicReference);
//                    atomicReference.compareAndSet(120, 100);
//                    System.out.println(Thread.currentThread().getName()+"发生了ABA：\t"+atomicReference);
//                }, "B"
//        ).start();
//
//        new Thread(
//                () -> {
//                       boolean flag =  atomicReference.compareAndSet(100, 120);
//                        System.out.println(Thread.currentThread().getName()+" "+atomicReference);
//                }, "A"
//        ).start();

        new Thread(
                () -> {
                    int stamp = atomicStampedReference.getStamp();
                    atomicStampedReference.compareAndSet(150, 200, stamp, stamp+1);
                    System.out.println(Thread.currentThread().getName()+" "+atomicStampedReference.getReference());
                    atomicStampedReference.compareAndSet(200, 150, stamp+1, stamp+2);
                    System.out.println(Thread.currentThread().getName()+"发生了ABA：\t"+atomicStampedReference.getReference());
                }, "D"
        ).start();

        new Thread(
                () -> {
                    ArrayList<Integer> objects = new ArrayList<>();
                    objects.add(1);
                    int stamp = atomicStampedReference.getStamp();
                    atomicStampedReference.compareAndSet(150, 200, stamp, stamp+1);
                    System.out.println(Thread.currentThread().getName()+" "+atomicStampedReference.getReference());
                }, "C"
        ).start();
    }
}
