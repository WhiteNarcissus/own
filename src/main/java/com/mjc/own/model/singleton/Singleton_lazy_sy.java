package com.mjc.own.model.singleton;

/**
 * 懒汉加锁版
 * 是否 Lazy 初始化：是
 *
 * 是否多线程安全：是
 *
 * 实现难度：易
 *
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 */

public class Singleton_lazy_sy {
  private static  Singleton_lazy_sy instance ;
  //构造方法私有化
  private Singleton_lazy_sy(){}
    public static synchronized Singleton_lazy_sy getInstance() {
        if (instance == null) {
            instance = new Singleton_lazy_sy();
        }
        return instance;
    }




}
