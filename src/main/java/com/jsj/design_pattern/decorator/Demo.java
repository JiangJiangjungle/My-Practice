package com.jsj.design_pattern.decorator;

public class Demo {

    public static void main(String[] args) {
        //原来的对象
        Component component = new ComponentImplemet();
        System.out.println("---------Component实现类------------------------------");
        //原来的方法
        component.method();
        //装饰成A
        DecoratorA decoratorA = new DecoratorA(component);
        System.out.println("---------Component实现类+DecoratorA包装------------------------------");
        //原来的方法
        decoratorA.method();
        //装饰成A以后新增的方法
        decoratorA.methodA();
        //装饰成B
        DecoratorB decoratorB = new DecoratorB(component);
        System.out.println("---------Component实现类+DecoratorB包装------------------------------");
        //原来的方法
        decoratorB.method();
        //装饰成B以后新增的方法
        decoratorB.methodB();
        //装饰成A以后再装饰成B
        decoratorB = new DecoratorB(decoratorA);
        System.out.println("---------Component实现类+DecoratorA包装+DecoratorB包装------------------------------");
        //原来的方法
        decoratorB.method();
        //装饰成B以后新增的方法
        decoratorB.methodB();
    }
}
