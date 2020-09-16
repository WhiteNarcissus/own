package com.mjc.own.thread;

public class DeadLock {

    public static void main(String[] args){
        //两个龙珠 集齐召唤圣龙
        Object a =new Object();
        Object b =new Object();

        //悟空先拿 a
        new Thread(()->{
            synchronized (a){
            System.out.println(Thread.currentThread().getName()+"悟空：我拿到a了"+a);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"悟空： 我去拿b了");
                }
            }

        }).start();


        //弗利萨 拿 b
        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"弗利萨：我拿到了"+b);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "弗利萨：要去拿a" + a);
                }
            }

        }).start();


    }


}
