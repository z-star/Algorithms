package com.fovoy.algorithms.design.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class DynamicProxy implements InvocationHandler {

    private final Target target;

    public DynamicProxy(Target target) {
        this.target = target;
    }

    public Target getProxy() {
        return (Target) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object o = method.invoke(target, args);
        doAfter();
        return o;
    }

    private void doBefore() {
        System.out.println("代理类开始");
    }

    private void doAfter() {
        System.out.println("代理类结束");
    }

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy((Target) () -> System.out.println("动态代理测试..."));
        Target target = dynamicProxy.getProxy();
        target.execute();
    }
}
