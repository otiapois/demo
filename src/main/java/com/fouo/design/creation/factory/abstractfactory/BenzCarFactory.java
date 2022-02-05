package com.fouo.design.creation.factory.abstractfactory;

import com.fouo.design.creation.factory.factorymethod.AbstractCarFactory;
import com.fouo.design.creation.factory.factorymethod.BenzCar;

/**
 * 产品工厂
 *
 * @author fouo
 * @date 2022/2/1 16:36
 */
public class BenzCarFactory extends AbstractCarFactory {

    @Override
    public BenzCar createCar() {
        return new BenzCar();
    }
}
