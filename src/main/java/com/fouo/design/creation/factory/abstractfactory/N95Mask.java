package com.fouo.design.creation.factory.abstractfactory;

/**
 * 口罩实现类 （产品等级）
 *
 * @author fouo
 * @date 2022/2/1 17:30
 */
public class N95Mask extends AbstractMask {

    @Override
    public void proctedMe() {
        this.price = 20;
        System.out.println("N95口罩保护生效 价格 ：" + price);
    }
}
