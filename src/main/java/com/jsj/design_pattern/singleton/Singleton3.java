package com.jsj.design_pattern.singleton;

/**
 * 利用枚举实现单例，可以避免反射机制对单例的破坏，但不是懒加载
 */
public enum Singleton3 {
    INSTANCE;
}
