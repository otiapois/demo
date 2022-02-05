package com.fouo.ref;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * WeakHashMapDemo
 *
 * @author fouo
 * @date 2020/10/31 16:30
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
//        myHashMap();
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap();
        Integer key = new Integer(2);
        String value = "Dream";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.gc();
        System.out.println(map);
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "Dream";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.gc();
        System.out.println(map);
    }
}
