package com.fouo.design.structural.bridge;
/**
 * 抽象销售渠道
 *
 * @author fouo
 * @date 2022/2/2 15:28
 */
public abstract  class AbstarctSale {
    private String type;
    private Integer price;

    public AbstarctSale(String type, Integer price) {
        this.type = type;
        this.price = price;
    }

    String getSaleInfo(){
        return "渠道"+type+"====> 价格："+price;
    }
}
