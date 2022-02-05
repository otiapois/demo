package com.fouo.design.structural.proxy.dynamic;

/**
 * 动态代理测试类
 *
 * 代理对象和目标对象的相同点在于都是实现同一个接口
 * @author fouo
 * @date 2022/2/2 16:49
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        ManTikTok chouTikTok = new ChouTikTok();
        ManTikTok proxy = DynamicTikTokProxy.getProxy(chouTikTok);
        proxy.tiktok();
        //只能代理 被代理对象实现接口中所规定的方法
        //不能代理 被代理对象类里面实现的方法  如果调用被代理对象的方法就会报错（类型转换异常）
//        ChouTikTok proxy = DynamicTikTokProxy.getProxy(chouTikTok);  会报错


    }
}
