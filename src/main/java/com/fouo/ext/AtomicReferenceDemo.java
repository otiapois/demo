package com.fouo.ext;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 *
 * @author fouo
 * @date 2020/10/28 20:15
 */
@Data
@AllArgsConstructor
class User{

    String userName;
    int age;
}
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User zhangsan = new User("张三", 22);
        User lisi = new User("李四", 24);

        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(zhangsan);
        System.out.println(userAtomicReference.compareAndSet(zhangsan,lisi));

    }
}
