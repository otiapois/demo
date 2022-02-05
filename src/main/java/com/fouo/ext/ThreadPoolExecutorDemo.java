package com.fouo.ext;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池演示
 *
 * @author fouo
 * @date 2020/10/30 13:11
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(50);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,queue);
        System.out.println(threadPoolExecutor.getThreadFactory());
        System.out.println(threadPoolExecutor.getRejectedExecutionHandler());
    }
}
