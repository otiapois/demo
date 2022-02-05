package com.fouo.juc;

import java.util.concurrent.*;

public class CompletableFutureDemo6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.element());

//        Integer join = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("1111");
//            return 1;
//        }).thenCombine(CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("2222");
//            return 2;
//        }), (a, b) -> {
//            return a + b;
//        }).join();
//        System.out.println(join);
    }
}
