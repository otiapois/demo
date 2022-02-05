package com.fouo.design.structural.proxy.cglib;

/**
 * 动态代理测试类
 *
 * 代理对象和目标对象的相同点在于都是实现同一个接口
 * @author fouo
 * @date 2022/2/2 16:49
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
//        ChouTikTok chouTikTok = new ChouTikTok();
        ChouTikTok proxy = DynamicTikTokProxy.createProxy(ChouTikTok.class);
        proxy.tiktok();
    }
}
