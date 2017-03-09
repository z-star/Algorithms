package com.fovoy.algorithms.design.factory;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class ProductA implements Product {

    @Override
    public void name(String name) {
        System.out.println(name);
    }

    @Override
    public void execute(int num) {
        System.out.println(num);
    }
}
