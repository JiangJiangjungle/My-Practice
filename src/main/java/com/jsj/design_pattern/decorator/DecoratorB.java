package com.jsj.design_pattern.decorator;

public class DecoratorB extends AbstractDecorator {

    public DecoratorB(Component component) {
        super(component);
    }

    public void methodB() {
        System.out.println("被装饰器B扩展的功能");
    }

    @Override
    public void method() {
        System.out.println("针对该方法加一层B包装");
        super.method();
        System.out.println("B包装结束");
    }
}
