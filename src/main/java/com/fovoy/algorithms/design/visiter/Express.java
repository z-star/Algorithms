package com.fovoy.algorithms.design.visiter;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public interface Express {

    void accept(Visitor visitor);

    void doSomething();
}
