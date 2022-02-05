package com.fouo.ref;

import java.lang.ref.SoftReference;

/**
 * 软引用demo
 *
 * @author fouo
 * @date 2020/10/31 15:40
 */
public class SoftReferenceDemo {
    public static void softRef_Memory_Enough() {

        Object o1 = new Object();
        SoftReference<Object> soft = new SoftReference<>(o1);

        System.out.println("强引用"+o1);
        System.out.println("软引用"+soft.get());

        o1 = null;
        System.gc();

        System.out.println("强引用"+o1);
        System.out.println("软引用"+soft.get());

    }

    public static void softRef_Memory_NotEnough() {

        Object o1 = new Object();
        SoftReference<Object> soft = new SoftReference<>(o1);

        System.out.println("强引用"+o1);
        System.out.println("软引用"+soft.get());

        o1 = null;
        System.gc();

       try {
            byte[]  arr = new byte[30*1024*1024];
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           System.out.println("强引用"+o1);
           System.out.println("软引用"+soft.get());
       }
    }

    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
