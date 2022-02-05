package com.fouo.gc;

/**
 * 在java中，可以作为GC Roots的对象
 * 1.虚拟机栈（栈帧中本地变量表（局部变量））中引用的对象
 * 2.方法区中静态类属性引用的对象
 * 3.方法区中常量引用的对象
 * 4.本地方法栈中JNI（即一般说的Native方法） 中引用的对象
 *
 * @author fouo
 * @date 2020/10/30 17:30
 */
public class GCRootsDemo {
    private byte[] bateArray = new byte[1024 * 1024 * 1024];

    //    private static GCRootsDemo2 t2;
//    private static final GCRootsDemo3 t3 = new GCRootsDemo3();
    public static void m1() {
        GCRootsDemo t1 = new GCRootsDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
