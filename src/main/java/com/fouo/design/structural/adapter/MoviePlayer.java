package com.fouo.design.structural.adapter;

/**
 * 电影播放器
 *
 * @author fouo
 * @date 2022/2/2 14:47
 */
public class MoviePlayer implements Player {
    @Override
    public String play() {
        System.out.println("正在播放电影");
        String content = "hello world";
        System.out.println(content);
        return content;
    }
}
