package com.fouo.design.structural.composite;

/**
 * 组合模式测试类
 *
 * @author fouo
 * @date 2022/2/2 20:37
 */
public class CompositeTest {
    public static void main(String[] args) {
        Menu menu = new Menu(1,"张三");
        menu.printMenu();
    }
}
