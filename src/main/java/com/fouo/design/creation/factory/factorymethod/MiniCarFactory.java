package com.fouo.design.creation.factory.factorymethod;

/**
 * 产品工厂
 *
 * @author fouo
 * @date 2022/2/1 16:36
 */
public class MiniCarFactory extends AbstractCarFactory {

    @Override
    public MiniCar createCar() {
        return new MiniCar();
    }
}
