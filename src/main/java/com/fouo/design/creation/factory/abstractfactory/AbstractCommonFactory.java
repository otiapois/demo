package com.fouo.design.creation.factory.abstractfactory;

import com.fouo.design.creation.factory.factorymethod.AbstractCar;

/**
 * 抽象工厂层级
 *
 * @author fouo
 * @date 2022/2/1 16:34
 */
public abstract class AbstractCommonFactory {

    //造车
    public abstract AbstractCar createCar();
    //造口罩
    public abstract AbstractMask createMask();
}
