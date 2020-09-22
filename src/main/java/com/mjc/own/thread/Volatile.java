package com.mjc.own.thread;
/**
 *
 * volatile赋予了变量可见——禁止编译器对成员变量进行优化，它修饰的成员变量在每次被线程访问时，都强迫从内存中重读该成员变量的值；
 * 而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存，这样在任何时刻两个不同线程总是看到某一成员变量的同一个值，这就是保证了可见性。
 *
 *对long和double的简单操作之外，volatile并不能提供原子性。所以，就算你将一个变量修饰为volatile，
 * 但是对这个变量的操作并不是原子的，在并发环境下，还是不能避免错误的发生！
 */
public class Volatile {

    //加上volatile后也会退出while死循环
    private  static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {

            int i = 0;
            while(!ready) {
//去掉注释同样会退出死循环
Thread.currentThread().yield();
//去掉注释同样会退出死循环
// System.out.println(i++);
 System.out.println("run ready:"+ready);
            }
            System.out.println(number);

        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ReaderThread();
        thread.start();
// Thread.currentThread().yield();
        Thread.currentThread().sleep(10);
        number = 42;
// System.out.println("before..."+ready);
//输出了 main read:true 程序还在运行。
        ready = true;
// System.out.println("after..."+ready);
        System.out.println("main read:"+ready);
// thread.interrupt();

    }
}
