package com.fouo.ref;

import java.lang.ref.WeakReference;

/**
 * 弱引用demo
 *
 * @author fouo
 * @date 2020/10/31 15:40
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weak = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(weak.get());
        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(weak.get());
    }
}
