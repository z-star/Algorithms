package com.fovoy.algorithms.design.observe;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class SubjectImpl implements Subject {
    private ConcurrentHashMap map = new ConcurrentHashMap();
    private final String name;

    public SubjectImpl(String name) {
        this.name = name;
    }

    @Override
    public void addObserver(String name, Observer observer) {
        if (!map.containsKey(name)) {
            map.put(name, observer);
        }
    }

    @Override
    public void removeObserver(String name) {
        map.remove(name);
    }

    @Override
    public void notifyObserver() {
        Set<Map.Entry<String, Observer>> entry = map.entrySet();
        for (Map.Entry<String, Observer> o : entry) {
            o.getValue().notify();
        }
    }
}
