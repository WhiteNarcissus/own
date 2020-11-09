package com.mjc.own.model.template;

import java.util.Random;

public class TestA  extends TestTemplate{

    @Override
   public void takerName(String name) {
        super.takerName(name);
    }

    @Override
    int questA(String answerA) {
        System.out.println(name +"的选择题得分");
        return new Random(10).nextInt();
    }

    @Override
    int questB(String answerB) {
        System.out.println(name +"的填空得分");
        return new Random(2).nextInt();

    }

    @Override
    public int submit(String answerA, String answerB) {
        return super.submit(answerA, answerB);
    }
}
