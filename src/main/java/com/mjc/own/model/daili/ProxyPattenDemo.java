package com.mjc.own.model.daili;

import com.mjc.own.model.strategy.demo.Context;

public class ProxyPattenDemo {
    public static void main(String[] args){
        //客户端
       Image image = new ProxyImage("AAAA.JPG");

       Image image1 = new RealImage("aaaaa.jpg");


       image.display();

       image1.display();



    }



}
