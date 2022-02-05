package com.fouo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long l = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            int temp = i ;
            Integer join = CompletableFuture.supplyAsync(() -> {

                return 1;
            }).join();
            System.out.println(join);
        }
        long e = System.currentTimeMillis();
        System.out.println(e-l);

        long l2 = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            int temp = i ;
            temp = i++;
            System.out.println(1);
        }
        long e2 = System.currentTimeMillis();
        System.out.println(e2-l2);


    }
}
