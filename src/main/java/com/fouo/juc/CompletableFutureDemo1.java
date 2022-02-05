package com.fouo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Integer future = CompletableFuture.supplyAsync(() -> {
            System.out.println( Thread.currentThread().getName()+"====>future");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 1;
        }).whenComplete((res,e)->{
            if(e==null){
                System.out.println("vvvvvv=>"+res);
            }else{
                System.out.println("log error");
            }
        }).exceptionally(e->{
            e.printStackTrace();
            return null;
        }).join();

        System.out.println(future);
        System.out.println( Thread.currentThread().getName()+"====>");
        TimeUnit.SECONDS.sleep(3);
    }
}
