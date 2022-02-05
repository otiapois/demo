package com.fouo.exception;

import java.util.Random;

public class OutOfMemoryError {
    public static void main(String[] args) {

        String d = "I want to the SouthSea";

        while (true){
            d += d +new Random().nextInt(11111111)+new Random().nextInt(22222222);
            d.intern();
        }
    }
}
