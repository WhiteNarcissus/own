package com.mjc.own.model.strategy.demo;

public class CutStrategy   implements  Strategy{

    @Override
    public Integer doOperation(int a ,int b) {

        return a+b;
    }

}
