package com.example.help.model.strategy.demo;

public class SumStrategy implements  Strategy {
    @Override
    public Integer doOperation(int a, int b) {
        return a+b;
    }
}
