package com.fouo.threadpool;

import java.util.concurrent.*;

/**
 * 线程池
 *
 * @author fouo
 * @date 2021/11/10 23:47
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 16, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5)
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
