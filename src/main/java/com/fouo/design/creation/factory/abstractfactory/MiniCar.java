package com.fouo.design.creation.factory.abstractfactory;

/**
 * car实现类 具体产品
 *
 * @author fouo
 * @date 2022/2/1 15:31
 */
public class MiniCar extends AbstractCar {

    public MiniCar() {
        this.engine = "mini的引擎";
    }

    @Override
    public void run() {
        System.out.println(engine + "   run");
    }
}
