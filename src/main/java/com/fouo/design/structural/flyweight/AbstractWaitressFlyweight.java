package com.fouo.design.structural.flyweight;
/**
 * 抽象享元类
 *
 * @author fouo
 * @date 2022/2/2 21:06
 */
public abstract class AbstractWaitressFlyweight {
    //以上是不变的
    boolean canService = true;//能否服务
    //正在服务  享元的不可共享属性留给外部进行改变的接口
    abstract void service();
    //服务完成  享元的不可共享属性留给外部进行改变的接口
    abstract void  end();
    public  boolean isCanService(){
        return canService;
    }
}
