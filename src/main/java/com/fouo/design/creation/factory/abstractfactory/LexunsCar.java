package com.fouo.design.creation.factory.abstractfactory;

/**
 * car实现类 具体产品
 *
 * @author fouo
 * @date 2022/2/1 15:31
 */
public class LexunsCar  extends AbstractCar {

    public LexunsCar() {
        this.engine = "雷克萨斯的引擎";
    }

    @Override
    public void run() {
        System.out.println(engine+"   run");
    }
}
