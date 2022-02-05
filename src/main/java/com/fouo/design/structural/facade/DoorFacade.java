package com.fouo.design.structural.facade;

/**
 * 门面类
 *
 * @author fouo
 * @date 2022/2/2 20:52
 */
public class DoorFacade {
    Edu edu = new Edu();
    Police police = new Police();
    Social social = new Social();

    public void handle() {
        edu.assignSchool();
        police.assignPolice();
        social.assignSocial();
    }
}
