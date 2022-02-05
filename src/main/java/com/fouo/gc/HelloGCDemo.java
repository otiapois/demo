package com.fouo.gc;

/**
 *
 *
 * @author fouo
 * @date 2020/10/30 18:02
 */

public class HelloGCDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
