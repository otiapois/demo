package com.fouo.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();

        //创建一个队列
        ReferenceQueue<Object> queue = new ReferenceQueue<>();

        //创建虚引用
        PhantomReference<Object> reference = new PhantomReference<>(o1, queue);

        System.out.println(o1);
        System.out.println(reference.get());
        System.out.println(queue.poll());


        System.out.println("=============================");
        o1 = null;
        System.gc();
        Thread.sleep(3);
        System.out.println(o1);
        System.out.println(reference.get());
        System.out.println(queue.poll());

    }
}
