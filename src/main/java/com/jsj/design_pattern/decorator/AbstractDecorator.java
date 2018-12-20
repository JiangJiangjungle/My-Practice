package com.jsj.design_pattern.decorator;

public abstract class AbstractDecorator implements Component {

    private Component component;

    public AbstractDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void method() {
        component.method();
    }
}
