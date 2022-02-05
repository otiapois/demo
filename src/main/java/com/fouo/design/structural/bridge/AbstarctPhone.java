package com.fouo.design.structural.bridge;

/**
 * 抽象手机
 * 手机有各种销售渠道价格都不一样
 *
 * @author fouo
 * @date 2022/2/2 15:28
 */
public abstract class AbstarctPhone {
    //这是桥接的位置....设置期间就得想好
    AbstarctSale sale;//分离渠道【桥接的关注点】

    //abstract int getPrice();如果这么写需要写多少个实现，违反开闭原则   手机线上 线下价格不一样 这样写
    // 就得分多个纬度
    abstract String getPhone();

    public void setSale(AbstarctSale sale) {
        this.sale = sale;
    }
}
