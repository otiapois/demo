package com.fouo.design.creation.factory.factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        AbstractCarFactory miniFactory = new MiniCarFactory();
        AbstractCar mini = miniFactory.createCar();
        mini.run();
    }
}
