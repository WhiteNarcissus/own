package com.mjc.own.thread;

/**
 * Created by gcb on 2019/4/28.
 * 用于测试 共享的可变状态 的可见性
 */
public class NoVisibility {

    private static  boolean reday ;
    private static  int number ;




    private static class ReaderThread extends Thread {

        public void  run() {
            while (!reday)
                Thread.yield();
                System.out.println(number);
        }


    }


    public static  void main(String[] args){
        new ReaderThread().start();
        number = 42 ;
        reday = true ;

    }


}
