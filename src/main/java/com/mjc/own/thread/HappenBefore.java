package com.mjc.own.thread;

/**
 * Created by gcb on 2019/4/29.
 *
 * 验证 并发编程 下的 happen-before 原则
 */
public class HappenBefore {
    static int a = 1;
    static int b = 1;

      /**
       线程中所有的操作都先行发生于线程的终止检测，我们可以通过Thread.join()方法结束、Thread.isAlive()的返回值手段检测到线程已经终止执行
       就是线程终止是有一个检测机制的，通过join可以在线程结束的时候加入另一个线程操作，相当于a.join(b)就是等b线程结束之后，a才会执行
       */
    public static void main(String[] args){
        Thread tb = new Thread(() -> {
            a = 2;
            b = 3;
            System.out.println(b);
        });
        Thread ta = new Thread(() -> {

            try {
                tb.join();
            } catch (InterruptedException e) {
                //NO
            }
            System.out.println(a);
        });

        ta.start();
        tb.start();
    }


}
