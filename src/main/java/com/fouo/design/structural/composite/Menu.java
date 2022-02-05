package com.fouo.design.structural.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式菜单实体
 *
 * @author fouo
 * @date 2022/2/2 20:34
 */
@Data
public class Menu {
    private Integer id;
    private String name;

    public Menu(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    //组合模式关注点
    private List<Menu> childs = new ArrayList<>();
    //提供添加层级的方法
    void addChildMenu(Menu menu){
        childs.add(menu);
    }
    //层级遍历
    void printMenu(){
        System.out.println(name);
        for (Menu child : childs) {
            child.printMenu();
        }
    }
}
