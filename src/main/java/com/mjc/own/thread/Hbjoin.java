package com.mjc.own.thread;

/**
 * Created by gcb on 2019/4/29.
 */
public class Hbjoin {
    static int a = 1;


    public static void main(String[] args){
        Thread tb = new Thread(() -> {
            a = 2;
            System.out.println(a);
        });
        Thread ta = new Thread(() -> {

            try {
                tb.join();
            } catch (InterruptedException e) {
                //NO
            }
            System.out.println(a);
        });
        tb.start();
        try {
            tb.sleep(5);
        }
      catch (Exception e){
            e.printStackTrace();
      }

        ta.start();

    }
}
