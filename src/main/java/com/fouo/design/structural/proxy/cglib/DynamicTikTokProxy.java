package com.fouo.design.structural.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Tiktok代理
 * 代理一般都是和被代理对象属于通一个接口
 * Cglib动态代理
 *
 * @author fouo
 * @date 2022/2/2 16:10
 */
public class DynamicTikTokProxy{

    //为任意对象创建代理
    public static <T> T createProxy(Class<T> t) {
        // 创建一个增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类，增强器给t动态创建一个子类
        enhancer.setSuperclass(t);
        // 设置方法回调
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o
             * @param method 只是可以获取到原方法的一些元数据信息
             * @param args
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public T intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //调用方法之前，我们可以添加自己的操作
                System.out.println("代理方法调用前");
                Object object = methodProxy.invokeSuper(o, args);
                System.out.println("代理方法调用后");
                //调用方法之后，我们同样可以添加自己的操作
                return (T)object;
            }
        });//核心方法
        return (T) enhancer.create();
    }

//    @Override
//    public T intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        //调用方法之前，我们可以添加自己的操作
//        System.out.println("代理方法调用前");
//        Object object = methodProxy.invokeSuper(o, args);
//        System.out.println("代理方法调用后");
//        //调用方法之后，我们同样可以添加自己的操作
//        return (T)object;
//    }
}
