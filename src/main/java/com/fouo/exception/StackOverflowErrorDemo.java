package com.fouo.exception;

/**
 * StackOverflowErrorDemo
 *
 * @author fouo
 * @date 2020/11/1 11:07
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
