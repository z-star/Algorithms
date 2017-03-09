package com.fovoy.algorithms.design.factory;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.sun.org.apache.bcel.internal.generic.CALOAD;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class Factory {
    public Product createProduct(String name){
        Product product=null;
        switch (name){
            case "A":
                product=new ProductA();
                break;
            case "B":
                product=new ProductB();
        }
        return product;
    }
}
