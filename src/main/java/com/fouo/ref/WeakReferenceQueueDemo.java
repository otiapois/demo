package com.fouo.ref;


import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceQueueDemo {
    public static void main(String[] args) {

        Object o1 = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("===========================================");
        o1 = null;
        System.gc();
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }
}
