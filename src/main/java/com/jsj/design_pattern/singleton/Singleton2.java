package com.jsj.design_pattern.singleton;

/**
 * 利用静态内部类实现单例，同样可以做到懒加载（即LazyHolder类加载时才进行单例实例化，而不是Singleton2类加载）
 */
public class Singleton2 {

    private static class LazyHolder {
        private static Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
