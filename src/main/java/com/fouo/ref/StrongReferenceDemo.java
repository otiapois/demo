package com.fouo.ref;

/**
 * 强引用
 *
 * @author fouo
 * @date 2020/10/31 15:32
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();//这样定义的默认就是强引用
        Object o2 = o1;//o2引用赋值
        o1 = null;//质控
        System.gc();
        System.out.println(o2);
    }
}
