package com.fouo.design.creation.builder;

/**
 * 抽象建造者
 *
 * @author fouo
 * @date 2022/2/1 18:21
 */
public abstract class AbstractBuilder {
    Phone phone;
    //定制cpu
    abstract  AbstractBuilder customCpu(String cpu);
    //定制内存
    abstract  AbstractBuilder customMem(String mem);
    //定制磁盘
    abstract  AbstractBuilder customDisk(String disk);
    //定制相机
    abstract  AbstractBuilder customCam(String cam);

    public Phone getPhone(){
        return this.phone;
    }
}
