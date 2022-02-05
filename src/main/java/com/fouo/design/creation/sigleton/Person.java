package com.fouo.design.creation.sigleton;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;

    //懒汉，饿汉
    private static volatile Person instance;

    //构造器私有,外部不能实例化
    private Person(){
        System.out.println("fouo 被创建了");
    }

    //单例提供给外部的方法(懒汉)
    public static Person getFouo(){
        if(instance == null){
            synchronized (Person.class){
                if(instance == null){
                    instance = new Person();
                }
            }
        }
        return instance;
    }
}
