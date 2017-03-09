package com.fovoy.algorithms.design.Proxy;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class StaticProxy implements Target {

    private final Target target;

    public StaticProxy(Target target) {
        this.target = target;
    }

    @Override
    public void execute() {
        doBefore();
        target.execute();
        doAfter();
    }

    private void doBefore() {
        System.out.println("代理类开始");
    }

    private void doAfter() {
        System.out.println("代理类结束");
    }
}
