package com.fovoy.algorithms.design.responsibility;

/**
 * Created by zxz.zhang on 2017/3/9.
 */
public abstract class Handler<T> {

    private Handler<T> handler;

    public Handler<T> getHandler() {
        return handler;
    }

    public void setHandler(Handler<T> handler) {
        this.handler = handler;
    }

    private T handle(T request) {
        T re = handleRequest(request);
        if (getHandler() != null) {
            re = getHandler().handle(re);
        }
        return re;
    }

    protected abstract T handleRequest(T request);

    public static void main(String[] args) {
        Handler h1 = new Handler<String>() {
            @Override
            protected String handleRequest(String request) {
                request = request + " 加一段";
                return request;
            }
        };
        Handler h2 = new Handler<String>() {
            @Override
            protected String handleRequest(String request) {
                request = request + " 加二段";
                return request;
            }
        };
        h1.setHandler(h2);
        System.out.println(h1.handle("测试一下责任链模式"));

    }
}
