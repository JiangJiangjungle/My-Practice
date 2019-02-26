package com.jsj.design_pattern.proxy;

public class Demo {

    public static void main(String[] args) {
        Target targetImplement = new TargetImplement();
        Object object = JDKProxy.bind(targetImplement);
        Target target1 = (Target) object;
        target1.method();
        System.out.println("-------------------------");
        Target2 target2 = (Target2) object;
        target2.method2();
        System.out.println("-------------------------");
        object = CglibProxy.bind(targetImplement);
        TargetImplement proxy = (TargetImplement) object;
        proxy.ownMethod();
    }
}
