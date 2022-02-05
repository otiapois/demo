package com.fouo.design.creation.factory.factorymethod;

import com.fouo.design.creation.factory.abstractfactory.AbstractCommonFactory;
import com.fouo.design.creation.factory.abstractfactory.AbstractMask;

/**
 * 抽象工厂层级
 *
 * @author fouo
 * @date 2022/2/1 16:34
 */
public abstract class AbstractCarFactory extends AbstractCommonFactory {

    @Override
    public abstract AbstractCar createCar();
    //造口罩
    @Override
    public  AbstractMask createMask(){
        return null;
    };

}
