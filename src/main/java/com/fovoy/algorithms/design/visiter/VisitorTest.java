package com.fovoy.algorithms.design.visiter;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class VisitorTest implements Visitor {
    private final String name;

    public VisitorTest(String name) {
        this.name = name;
    }

    @Override
    public void visitor(Express express) {
        express.doSomething();
    }

    public static void main(String[] args) {
        VisitorTest visitorTest = new VisitorTest("visitor");
        ExpressTest expressTest = new ExpressTest("express");
        expressTest.accept(visitorTest);
    }
}
