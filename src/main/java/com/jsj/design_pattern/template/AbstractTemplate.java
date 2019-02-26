package com.jsj.design_pattern.template;

/**
 * 抽象模板类
 */
public abstract class AbstractTemplate {

    protected abstract void preHandle();

    protected abstract void afterHandle();

    protected abstract void handle();

    /**
     * 确定抽象步骤
     */
    public void start() {
        System.out.println("work start!");
        preHandle();
        handle();
        afterHandle();
    }
}
