package com.fovoy.algorithms.design.template;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public abstract class Template {

    abstract void checkParam(String name);

    abstract void doBefore();

    abstract void doAfter();

    private void execute(String name) {
        checkParam(name);
        doBefore();
        System.out.println("执行任务");
        doAfter();
    }

    public static void main(String[] args) {
        Template template = new Template() {
            @Override
            void checkParam(String name) {
               if(name.length()>1){
                   System.out.println("参数正常");
               }
            }

            @Override
            void doBefore() {
                System.out.println("准备执行.....");
            }

            @Override
            void doAfter() {
                System.out.println("准备完毕!");
            }
        };
        template.execute("模板模式测试");
    }
}
