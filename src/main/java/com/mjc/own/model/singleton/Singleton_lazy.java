package com.mjc.own.model.singleton;

/**
 * 懒汉模式 支持懒加载 不支持多线程
 */
public class Singleton_lazy {

    private static Singleton_lazy instance;
    private Singleton_lazy (){}

    public static Singleton_lazy getInstance() {
        if (instance == null) {
            instance = new Singleton_lazy();
        }
        return instance;
    }
}
