package com.fouo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程的第3种方式
 * 实现callable接口
 *
 * futureTask.get() 该方法一般放在最后一行
 *
 */
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 1;
    }
}

public class ThreadCallableDemo {
    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask, "A").start();

        System.out.println(futureTask.get());
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName());
    }
}
