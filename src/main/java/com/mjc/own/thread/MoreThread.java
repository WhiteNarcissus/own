package com.example.help.thread;



import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MoreThread {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        int count=200000;
        final List<Integer> l =new LinkedList<>();
        ThreadPoolExecutor tp= new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(count));
        final Random random=new Random();
        for (int i=0;i<count;i++){
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            });
        }

        System.out.println(System.currentTimeMillis()-startTime);
        System.out.println(l.size());
    }


    public static void main1(String[] args) {
        long startTime =System.currentTimeMillis();
        final List<Integer> l=new LinkedList<>();
        final int count=200000;
        final Random random=new Random();
        for (int i = 0; i <count ; i++) {
            Thread thread=new Thread(){
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis()-startTime);
        System.out.println(l.size());
    }
}
