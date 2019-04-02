package com.jsj.jdk.demo.annotation;

import com.alibaba.fastjson.annotation.JSONType;

import javax.annotation.Resource;

@JSONType
@Resource
public interface AnnotationTestInterface {

    void methodA();
}
