package com.fouo.design.structural.proxy.statics;
/**
 * 静态代理测试类
 * 静态代理就可以看做是装饰器模式
 * 缺点：代理每种不同的代理对象要创建不同的静态代理类
 * @author fouo
 * @date 2022/2/2 16:49
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        TikTokProxy tikTokProxy = new TikTokProxy(new ChouTikTok());
        tikTokProxy.tiktok();
    }
}
