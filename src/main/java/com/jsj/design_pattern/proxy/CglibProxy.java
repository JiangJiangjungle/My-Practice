package com.jsj.design_pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private CglibProxy() {
    }

    public static Object bind(Object target) {
        Enhancer enhancer = new Enhancer();
        //设置代理对象的父类
        enhancer.setSuperclass(target.getClass());
        //回调方法
        enhancer.setCallback(new CglibProxy());
        //创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Use CglibProxy Before Method!");
        return methodProxy.invokeSuper(o, objects);
    }
}
