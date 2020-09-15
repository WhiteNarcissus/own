package com.example.help.thread;

/**
 * Created by gcb on 2019/4/29.
 * Thread对象的start()方法先行发生于此线程的每一个动作；
 */
public class Hbstart {

    static int a = 1;

    public static void main(String[] args){
        Thread tb = new Thread(() -> {
            System.out.println(a);
        });



        Thread ta = new Thread(() -> {
            tb.start();
            try {
                tb.sleep(5);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            a = 2;
        });


            ta.start();

    }

}
