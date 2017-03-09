package com.fovoy.algorithms.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class DynamicProxy<T> implements InvocationHandler {

    private T object;

    public DynamicProxy(T object) {
        this.object = object;
    }

    @SuppressWarnings("unchecked")
    public T getProxy() {
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(object, args);
        doAfter();
        return result;
    }

    private void doBefore() {
        System.out.println("doBefore");
    }

    private void doAfter() {
        System.out.println("doAfter");
    }

    public static void main(String[] args) {
        DynamicProxy<ProxyTest> dynamicProxy = new DynamicProxy(new ProxyTestImpl());
        ProxyTest proxyTest = dynamicProxy.getProxy();
        proxyTest.add();
    }
}
