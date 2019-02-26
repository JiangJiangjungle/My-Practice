package com.jsj.design_pattern.proxy;

public class TargetImplement2 implements Target {
    @Override
    public void method() {
        System.out.println("TargetImplement2 实现了 Target 的 method 方法");
    }
}
