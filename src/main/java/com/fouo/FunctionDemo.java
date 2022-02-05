package com.fouo;

import java.util.function.Function;

/**
 * 函数式接口
 *
 * @author fouo
 * @date 2020/10/20 17:08
 */
public class FunctionDemo {
    public static void main(String[] args) {
    /*    Function<String,Integer> fc = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 1;
            }
        };*/
        Function<String, Integer> fc = temp -> 1;
        Integer apply = fc.apply(1 + "");
        System.out.println(apply);
    }
}
