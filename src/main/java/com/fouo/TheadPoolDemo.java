package com.fouo;

import java.util.concurrent.*;

/**
 * @author fouo
 * @date 2020/10/20 13:43
 */
public class TheadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,
                3,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
//        ExecutorService executorService = Executors.newCachedThreadPool(); //线程池这样创建不规范
//        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
//        Executors.newCachedThreadPool();
        try {
//            System.out.println(Integer.MAX_VALUE);
            for (int i = 0; i < 10; i++) {
                threadPool.execute(
                        () -> {
                            System.out.println(Thread.currentThread().getName());
                        }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放线程池资源
            threadPool.shutdown();
        }
    }
}
