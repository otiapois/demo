package com.fouo.design.creation.factory.factorymethod;

/**
 * car实现类 具体产品
 *
 * @author fouo
 * @date 2022/2/1 15:31
 */
public class BenzCar extends AbstractCar {

    public BenzCar() {
        this.engine = "benz的引擎";
    }

    @Override
    public void run() {
        System.out.println(engine + "   run");
    }
}
