package com.fouo.design.structural.adapter;

/**
 * 适配器测试类
 * 适配器
 * 1.系统原有的两个接口 player translator没有任何关系
 * 2.在不修改原有的接口的基础上，需要一个适配器（扩展一个新的类），来连接之前两个不同的接口
 *
 * @author fouo
 * @date 2022/2/2 14:48
 */
public class AdapterTest {
    public static void main(String[] args) {
        //播放电影返回字幕
        MoviePlayer moviePlayer = new MoviePlayer();
        String content = moviePlayer.play();
    }
}
