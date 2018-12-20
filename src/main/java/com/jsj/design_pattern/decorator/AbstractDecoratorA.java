package com.jsj.design_pattern.decorator;

public class AbstractDecoratorA extends AbstractDecorator {

    public AbstractDecoratorA(Component component) {
        super(component);
    }

    public void methodA() {
        System.out.println("被装饰器A扩展的功能");
    }

    @Override
    public void method() {
        System.out.println("针对该方法加一层A包装");
        super.method();
        System.out.println("A包装结束");
    }
}
