package com.fovoy.algorithms.design.strategy;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public class Process {
    private final Strategy strategy;

    public Process(Strategy strategy) {
        this.strategy = strategy;
    }


    private void handle(String name) {
        strategy.execute(name);
    }

    public static void main(String[] args) {
        Process process = new Process(s -> {
            System.out.println(s);
        });
        process.handle("测试一个策略模式");
        Process process2 = new Process(s -> {
            System.out.println(s.substring(3));
        });
        process.handle("测试二个策略模式");
    }
}
