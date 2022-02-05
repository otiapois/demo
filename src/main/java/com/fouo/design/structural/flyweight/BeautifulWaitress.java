package com.fouo.design.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 具体享元类
 * 放在池子里面的东西
 * @author fouo
 * @date 2022/2/2 21:11
 */
@Data
@AllArgsConstructor
public class BeautifulWaitress extends AbstractWaitressFlyweight {
    String id;//工号
    String name;//名称
    int age;//年龄
    @Override
    void service() {
        System.out.println("工号："+id+"  "+name+"  "+age+" 正在服务");
        canService = false;
    }

    @Override
    void end() {
        System.out.println("工号："+id+"  "+name+"  "+age+" 服务完成");
        canService = true;
    }
}
