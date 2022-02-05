package com.fouo.design.structural.decorator;
/**
 * 装饰者设计模式测试类
 *
 * @author fouo
 * @date 2022/2/2 16:16
 */
public class DecoratorTest {
    public static void main(String[] args) {
        ChouTikTok chouTikTok = new ChouTikTok();
        chouTikTok.tiktok();
        ShabiDecorator shabiDecorator = new ShabiDecorator(chouTikTok);
        shabiDecorator.tiktok();
    }
}
