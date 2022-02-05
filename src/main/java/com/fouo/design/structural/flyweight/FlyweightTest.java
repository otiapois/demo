package com.fouo.design.structural.flyweight;

import java.util.UUID;

/**
 * 享元设计模式测试类
 *
 * @author fouo
 * @date 2022/2/2 21:26
 */
public class FlyweightTest {
    public static void main(String[] args) {
        AbstractWaitressFlyweight waitress1 = ZuDao.getWaitress("1111");
        waitress1.service();
        AbstractWaitressFlyweight waitress2 = ZuDao.getWaitress("2222");
        waitress2.service();
//        waitress2.end();
        AbstractWaitressFlyweight waitress3 = ZuDao.getWaitress("3333");
        waitress3.service();


    }
}
