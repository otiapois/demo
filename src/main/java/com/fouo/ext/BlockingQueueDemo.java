package com.fouo.ext;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue(2);
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
//        System.out.println(queue.add("a"));
//        System.out.println(queue.add("b"));
//        queue.remove("b");
//        System.out.println(queue.add("c"));

//        System.out.println(queue.offer("a"));
//        System.out.println(queue.offer("b"));
//        System.out.println(queue.offer("c"));
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());

//        queue.put("a");
//        queue.put("b");
//        System.out.println(queue.take());
//        queue.put("c");
//        System.out.println(queue.take());
//        System.out.println(queue.take());

        BlockingQueue<String> synQueue = new SynchronousQueue<>();
        new Thread(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        synQueue.put("a");
                        TimeUnit.SECONDS.sleep(1);
                        synQueue.put("b");
                        TimeUnit.SECONDS.sleep(1);
                        synQueue.put("c");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"A"
        ).start();
        Stack stack = new Stack();
        new Thread(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(synQueue.take());
                        System.out.println(synQueue.take());
                        System.out.println(synQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"B"
        ).start();
    }
}
