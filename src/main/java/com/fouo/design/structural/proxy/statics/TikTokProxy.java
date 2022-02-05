package com.fouo.design.structural.proxy.statics;

/**
 * Tiktok代理
 * 代理一般都是和被代理对象属于通一个接口
 *
 *
 * @author fouo
 * @date 2022/2/2 16:10
 */
public class TikTokProxy implements ManTikTok {

    //被代理对象
    private ChouTikTok chouTikTok;

    public TikTokProxy(ChouTikTok chouTikTok) {
        this.chouTikTok = chouTikTok;
    }

    @Override
    public void tiktok() {
        System.out.println("代理的业务逻辑");
        chouTikTok.tiktok();
        System.out.println("上面的方法也可以注解掉，不一定是增强");
    }
}
