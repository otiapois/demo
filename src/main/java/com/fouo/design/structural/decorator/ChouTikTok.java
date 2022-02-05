package com.fouo.design.structural.decorator;

/**
 * 抽象构件
 *
 * @author fouo
 * @date 2022/2/2 16:10
 */
public class ChouTikTok implements ManTikTok {

    @Override
    public void tiktok() {
        System.out.println("臭");
    }
}
