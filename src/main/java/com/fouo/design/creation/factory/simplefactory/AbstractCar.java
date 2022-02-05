package com.fouo.design.creation.factory.simplefactory;

import lombok.Data;

/**
 * 工厂的产品
 *
 * @author fouo
 * @date 2022/2/1 15:28
 */
@Data
public abstract class AbstractCar {
    public String engine;
    public abstract void run();
}
