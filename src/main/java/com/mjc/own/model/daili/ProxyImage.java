package com.mjc.own.model.daili;

public class ProxyImage implements  Image{
    RealImage realImage ;
    String fileName ;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }


    @Override
    public void display() {
        if(null== realImage) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }



}
