package com.fouo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * compete
 */
public class CompletableFutureDemo4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer future = CompletableFuture.supplyAsync(() -> {
           return 1;
        }).thenApply(e->{
            return e+1;
        }).join();
        System.out.println(future);
    }
}
