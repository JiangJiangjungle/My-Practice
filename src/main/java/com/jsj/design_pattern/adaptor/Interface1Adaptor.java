package com.jsj.design_pattern.adaptor;

public class Interface1Adaptor implements Interface2 {

    private Interface1 instance;

    public Interface1Adaptor(Interface1 instance) {
        this.instance = instance;
    }

    @Override
    public void methodB() {
        instance.methodA();
    }
}
