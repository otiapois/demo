package com.fouo.design.creation.factory.abstractfactory;

import lombok.Data;

/**
 *  抽象口罩（产品族）
 *
 * 怎么把一个功能提升一个层次：定义抽象（抽象类、接口）
 * 多实现就有多功能
 * @author fouo
 * @date 2022/2/1 15:28
 */
@Data
public abstract class AbstractMask {
    public Integer price;
    public abstract void proctedMe();
}
