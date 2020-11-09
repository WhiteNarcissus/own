package com.mjc.own.model.template;

public class TestB extends TestTemplate{
    @Override
  public   void takerName(String name) {
        super.takerName(name);
    }

    @Override
    int questA(String answerA) {
        System.out.println(name +"的选择题得分");
        return 0;
    }

    @Override
    int questB(String answerB) {
        System.out.println(name +"的填空题得分");
        return 0;
    }

    @Override
    public  int submit(String answerA, String answerB) {
        return super.submit(answerA, answerB);
    }
}
