package com.fouo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * compete
 */
public class CompletableFutureDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        TimeUnit.SECONDS.sleep(1);
        // 如果future执行被该方法打断成功  则返回ture   future返回的数据为 -44
        //如果打断失败则返回false  future 返回值会是future返回的值
        System.out.println(future.complete(-44));
        System.out.println(future.join());
    }
}
