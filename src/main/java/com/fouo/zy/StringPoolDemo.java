package com.fouo.zy;

/**
 * 第三季 字符串常量池
 *
 * @author fouo
 * @date 2020/11/2 1:13
 */
public class StringPoolDemo {

    public static void main(String[] args) {

        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }
}
