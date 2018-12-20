package com.jsj.design_pattern.decorator;

public class Demo {

    public static void main(String[] args) {
        //原来的对象
        Component component = new ComponentImplemet();
        System.out.println("------------------------------");
        //原来的方法
        component.method();
        //装饰成A
        AbstractDecoratorA decoratorA = new AbstractDecoratorA(component);
        System.out.println("------------------------------");
        //原来的方法
        decoratorA.method();
        //装饰成A以后新增的方法
        decoratorA.methodA();
        //装饰成B
        AbstractDecoratorB decoratorB = new AbstractDecoratorB(component);
        System.out.println("------------------------------");
        //原来的方法
        decoratorB.method();
        //装饰成B以后新增的方法
        decoratorB.methodB();
        //装饰成A以后再装饰成B
        decoratorB = new AbstractDecoratorB(decoratorA);
        System.out.println("------------------------------");
        //原来的方法
        decoratorB.method();
        //装饰成B以后新增的方法
        decoratorB.methodB();
    }
}
