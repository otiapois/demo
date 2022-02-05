package com.fouo.design.structural.bridge;
/**
 * 苹果手机
 *
 * @author fouo
 * @date 2022/2/2 15:49
 */
public class IPhone extends AbstarctPhone {
    @Override
    String getPhone() {
        return "Iphone: "+sale.getSaleInfo();
    }
}
