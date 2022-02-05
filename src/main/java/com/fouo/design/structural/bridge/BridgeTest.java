package com.fouo.design.structural.bridge;
/**
 * 桥接测试类
 *
 * 省去了创建很多类
 * @author fouo
 * @date 2022/2/2 15:50
 */
public class BridgeTest {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
        //设置渠道
        iPhone.setSale(new OnlineSale("线上",20));
        System.out.println(iPhone.getPhone());
    }
}
