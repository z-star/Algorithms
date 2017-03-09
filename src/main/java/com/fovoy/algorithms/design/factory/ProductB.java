package com.fovoy.algorithms.design.factory;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class ProductB implements Product {

    @Override
    public void name(String name) {
        System.out.println(name);
    }

    @Override
    public void execute(int num) {
        System.out.println(num);
    }
}
