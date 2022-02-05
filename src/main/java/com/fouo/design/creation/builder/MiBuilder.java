package com.fouo.design.creation.builder;
/**
 * 具体实现建造者
 *
 * @author fouo
 * @date 2022/2/1 18:23
 */
public class MiBuilder extends AbstractBuilder{

    public MiBuilder() {
//        phone = new Phone();
        phone = Phone.builder().build();
    }

    @Override
    MiBuilder customCpu(String cpu) {
        phone.setCpu(cpu);
        return this;
    }

    @Override
    MiBuilder customMem(String mem) {
        phone.setMem(mem);
        return this;
    }

    @Override
    MiBuilder customDisk(String disk) {
        phone.setDisk(disk);
        return this;
    }

    @Override
    MiBuilder customCam(String cam) {
        phone.setCam("1px");
        return this;
    }
}
