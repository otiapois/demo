package com.fouo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 多线程并发时集合类的各种情况
 *
 * @author fouo
 * @date 2020/10/17 11:03
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        /**
         * 写时复制集合类
         */
        HashSet hashSet = new HashSet();
        List<String> list = new CopyOnWriteArrayList<>(new ArrayList<String>());

        /**
         * 线程安全的hashmap
         */
        ConcurrentHashMap map = new ConcurrentHashMap();
    }
}
