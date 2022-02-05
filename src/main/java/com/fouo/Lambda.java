package com.fouo;

/**
 * 接口中只有一个方法的接口称为  函数式接口
 */
@FunctionalInterface
interface Foo{
    public void sayHello();
}

public class Lambda {
    public static void main(String[] args) {

        Foo foo = ()->   System.out.println("Hello World");
        foo.sayHello();
    }
}

