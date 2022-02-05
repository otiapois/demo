package com.fouo.design.structural.bridge;
/**
 * 华为手机
 *
 * @author fouo
 * @date 2022/2/2 15:49
 */
public class HuaWeiPhone extends AbstarctPhone {
    @Override
    String getPhone() {
        return "HuaWeiphone: "+sale.getSaleInfo();
    }
}
