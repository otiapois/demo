package com.fouo.design.creation.builder;

/**
 * 建造模式测试类
 *
 * @author fouo
 * @date 2022/2/1 18:27
 */
public class BuilderTest {
    public static void main(String[] args) {
//        AbstractBuilder abstractBuilder = new MiBuilder();
//        Phone phone = abstractBuilder.customCam("1px")
//                .customCpu("M14")
//                .customDisk("512G")
//                .customMem("256G")
//                .getPhone();
        //直接使用lombok插件 @Builder
        Phone phone = Phone.builder().cpu("M14").disk("512G").mem("256G").build();
        System.out.println(phone);
    }
}
