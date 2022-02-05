package com.fouo.design.creation.factory.abstractfactory;

import com.fouo.design.creation.factory.factorymethod.AbstractCar;
import com.fouo.design.creation.factory.factorymethod.AbstractCarFactory;
import com.fouo.design.creation.factory.factorymethod.MiniCarFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractCommonFactory beanzFactory = new BenzCarFactory();
        AbstractCar car = beanzFactory.createCar();
        car.run();

        AbstractCommonFactory maskFactory = new N95MaskFactory();
        AbstractMask mask = maskFactory.createMask();
        mask.proctedMe();
    }
}
