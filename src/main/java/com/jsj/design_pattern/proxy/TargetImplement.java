package com.jsj.design_pattern.proxy;

public class TargetImplement implements Target, Target2 {

    @Override
    public void method() {
        System.out.println("Target Implement method!");
    }

    @Override
    public void method2() {
        System.out.println("Target2 Implement method!");
    }

    public void ownMethod() {
        System.out.println("This is non Interface method!");
    }
}
