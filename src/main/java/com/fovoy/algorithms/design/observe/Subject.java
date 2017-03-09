package com.fovoy.algorithms.design.observe;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public interface Subject {

    void addObserver(String name, Observer observer);

    void removeObserver(String name);

    void notifyObserver();
}
