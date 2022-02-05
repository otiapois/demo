package com.fouo.ext;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者 阻塞队列版本
 * <p>
 * 涉及知识点 volatile/cas/atomicInteger/blockingqueue/线程交互
 *
 * @author fouo
 * @date 2020/10/30 9:53
 */

public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(
                () -> {
                    try {
                        myResource.myProd();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"Prod"
        ).start();

        new Thread(
                () -> {
                    try {
                        myResource.myCons();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"Cons"
        ).start();

        TimeUnit.SECONDS.sleep(5);
        myResource.stop();
    }
}

/**
 * 资源类
 */
class MyResource {

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;

        System.out.println(blockingQueue.getClass().getName());
    }

    private volatile boolean flag = true;//默认开启进行生产和消费 为了保证线程之间能够可见  需要加volatile
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;

    public void myProd() throws InterruptedException {

        String data = null;
        boolean returnValue;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            returnValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);

            if (returnValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void myCons() throws InterruptedException {

        String returnValue = null;
        while (flag) {
            returnValue = blockingQueue.poll(2L, TimeUnit.SECONDS);

            if ("".equalsIgnoreCase(returnValue) || returnValue == null) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过两秒没有生产，不能进行消费");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + returnValue + "成功");
        }
    }

    public void stop(){
        this.flag = false;
    }

}
