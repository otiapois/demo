package com.fouo.design.structural.facade;
/**
 * 外观设计模式（门面设计模式）
 * 尝用做网关
 * MVC三层架构也是
 * @author fouo
 * @date 2022/2/2 20:49
 */
public class FacadeTest {
    public static void main(String[] args) {
//        Edu edu = new Edu();
//        Police police = new Police();
//        Social social = new Social();
//        edu.assignSchool();
//        police.assignPolice();
//        social.assignSocial();
        DoorFacade doorFacade = new DoorFacade();
        doorFacade.handle();


    }
}
