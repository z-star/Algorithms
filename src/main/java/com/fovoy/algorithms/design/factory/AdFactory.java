package com.fovoy.algorithms.design.factory;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class AdFactory extends AbstractFactory {
    private final String name;

    public AdFactory(String name) {
        this.name = name;
    }

    @Override
    public Product createProduct(String name) {
        Product product = null;
        switch (name) {
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
        }
        return product;
    }
}
