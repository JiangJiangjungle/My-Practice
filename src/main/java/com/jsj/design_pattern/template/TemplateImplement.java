package com.jsj.design_pattern.template;

public class TemplateImplement extends AbstractTemplate {

    @Override
    protected void preHandle() {
        System.out.println("preHandle...");
    }

    @Override
    protected void afterHandle() {
        System.out.println("afterHandle...");
    }

    @Override
    protected void handle() {
        System.out.println("handle ");
    }

    public static void main(String[] args) {
        TemplateImplement implement = new TemplateImplement();
        implement.start();
    }
}
