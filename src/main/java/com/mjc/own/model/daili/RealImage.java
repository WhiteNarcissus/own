package com.mjc.own.model.daili;

public class RealImage implements Image {
    String fileName ;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadingImage(fileName);
    }

    @Override
    public void display() {
        System.out.println("dispaly" +fileName);
    }

    public void loadingImage(String fileName){
        System.out.println("loading" +fileName);
    }

}
