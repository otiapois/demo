package com.fouo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //哪个先执行完输出哪个结果
        System.out.println(CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("1s");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("2s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        }),r->{
            return r;
        }).join());

        TimeUnit.SECONDS.sleep(3);
    }
}
