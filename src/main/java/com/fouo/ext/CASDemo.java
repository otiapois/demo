package com.fouo.ext;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 机制
 *
 * @author fouo
 * @date 2020/10/28 15:25
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2);
//        atomicInteger.getAndIncrement();
//        System.out.println(atomicInteger);
        /**
         * expect是期望值
         * update是修改后的值
         *
         * 期望值参考JMMjava内存模型中 main线程的工作内存从主内存中复制后的值，期望这个值不会被其他线程先修改
         *
         * 如果期望值和从主内存中获取的值时一致的 返回true 然后才会修改
         */
        atomicInteger.compareAndSet(2,2020);
        atomicInteger.compareAndSet(2020,1024);
        System.out.println(atomicInteger);
//        int andIncrement = atomicInteger.getAndIncrement();
//        int i = atomicInteger.incrementAndGet();
//        System.out.println(i);

    }
}