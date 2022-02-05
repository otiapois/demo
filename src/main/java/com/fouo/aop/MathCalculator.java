package com.fouo.aop;

import org.springframework.stereotype.Component;

@Component
public class MathCalculator {

    @AopAnnotation
    public void printMath() {
        System.out.println(Math.random() + "=================>执行");
    }
}
