package com.fouo.design.creation.factory.simplefactory;

import java.util.Objects;

/**
 * 简单工厂
 * 1.产品数量很少
 *
 * @author fouo
 * @date 2022/2/1 15:30
 */
public class SimpleFactory {

    public AbstractCar createCar(String type){
        //简单工厂的核心
        if(Objects.equals(type, "L")){
            return new LexunsCar();
        }else if(Objects.equals(type, "M")){
            return new MiniCar();
        }
        //简单工厂的缺点：更多的产品，违反开闭原则（对扩展开放，对修改关闭）。应该直接扩展一个类来造
        return null;
    }
}
