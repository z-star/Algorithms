package com.fovoy.algorithms.design.visiter;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class ExpressTest implements Express {


    private final String name;

    public ExpressTest(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    @Override
    public void doSomething() {
        System.out.println(name);
    }
}
