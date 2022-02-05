package com.fouo.design.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Tiktok代理
 * 代理一般都是和被代理对象属于通一个接口
 * JDK动态代理
 *
 * @author fouo
 * @date 2022/2/2 16:10
 */
public class DynamicTikTokProxy<T> implements InvocationHandler {

    private T target;

     DynamicTikTokProxy(T target) {
        this.target = target;
    }

    /**
     * 获取被代理对象的代理对象
     * ClassLoader loader, 被代理对象的类加载器
     * Class<?>[] interfaces,被代理对象所实现的所有接口
     * InvocationHandler h 当前被代理对象执行目标方法的时候，我们使用h可以定义拦截增强方法
     * 即只要代理对象调用了任何方法，invo方法都会被执行
     *
     * @param t
     * @param <T>
     * @return
     */
    public static<T> T getProxy(T  t) {
        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                new DynamicTikTokProxy(t));
        return (T)o;
    }
//    public static<T> T getProxy(T t){
//        Object o = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return method.invoke(t, args);
//            }
//        });
//        return (T)o;
//    };

    /**
     * 定义目标方法在执行期间的拦截逻辑
     * 每个方法调用都会进来。
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //反射执行
        System.out.println("真正被执行的被代理对象的方法");
        Object invoke = method.invoke(target, args);
        System.out.println("真正被执行的被代理对象的方法");
        return invoke;
    }
}
