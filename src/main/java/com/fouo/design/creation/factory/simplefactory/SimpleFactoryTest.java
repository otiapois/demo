package com.fouo.design.creation.factory.simplefactory;

/**
 * 简单工厂测试类
 *
 * @author fouo
 * @date 2022/2/1 15:28
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        AbstractCar lexuns = simpleFactory.createCar("L");
        AbstractCar mini = simpleFactory.createCar("M");
        lexuns.run();
        mini.run();
    }
}
