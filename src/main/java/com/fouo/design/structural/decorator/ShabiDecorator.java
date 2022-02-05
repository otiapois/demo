package com.fouo.design.structural.decorator;

/**
 * 傻比装饰器
 *
 * @author fouo
 * @date 2022/2/2 16:10
 */
public class ShabiDecorator implements TikTokDecorator {

    private ChouTikTok chouTikTok;
    public ShabiDecorator(ChouTikTok chouTikTok) {
        this.chouTikTok = chouTikTok;
    }

    @Override
    public void tiktok() {
        chouTikTok.tiktok();
        System.out.println("傻比");
    }
}
