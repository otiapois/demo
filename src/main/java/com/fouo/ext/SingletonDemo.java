package com.fouo.ext;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 单例模式 中使用volatile
 *
 * @author fouo
 * @date 2020/10/28 14:32
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t  这是单例模式中的构造方法");
        ArrayList<Integer> list = new ArrayList<>();
        Collections.synchronizedList(list);
    }

    /*public static  *//*synchronized*//*  SingletonDemo getInstance() {

        if (instance == null) {
            instance = new SingletonDemo();
        }

        return instance;
    }*/
    //使用DCL 双端检索机制  在对象创建时 （1分配空间，2初始化，3分配引用  在2.3步会产生指令重排现象）
    //会导致在多线程状况下最终获取的线程对象为null
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
    /*    SingletonDemo instance = SingletonDemo.getInstance();
        System.out.println(instance);*/
        //单线程
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        //并发多线程后情况发生了很大的变化
        for (int i = 1; i <= 10; i++) {
            new Thread(
                    () -> {
                        SingletonDemo.getInstance();
                    }
            ).start();
        }
    }
}


