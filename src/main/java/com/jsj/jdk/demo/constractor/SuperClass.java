package com.jsj.jdk.demo.constractor;

public class SuperClass {
    Member m1 = new Member("父类的成员变量");

    {
        System.out.println("父类的构造代码块");
    }

    public SuperClass() {
        System.out.println("父类的构造函数");
    }
}
