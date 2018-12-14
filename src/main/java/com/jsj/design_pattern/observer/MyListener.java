package com.jsj.design_pattern.observer;

public class MyListener implements Listener {

    @Override
    public void complete() {
        System.out.println("Event已经结束！");
    }
}
