package com.fouo.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootTest
public class A {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private MathCalculator mathCalculator;
    @Test
    public void testAop(){
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//
        mathCalculator.printMath();


    }
}
