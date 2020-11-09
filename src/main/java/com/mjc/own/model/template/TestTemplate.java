package com.mjc.own.model.template;

public abstract class TestTemplate {


    protected   String name;
    int score = 0;

  public   void takerName(String name) {
        this.name = name;
    }

    abstract int questA(String answerA);

    abstract int questB(String answerB);


    public int submit(String answerA, String answerB) {
        score = questA(answerA) + questB(answerB);
        return score;
    }
}
