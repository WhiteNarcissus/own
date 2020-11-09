package com.mjc.own.model.template.demo;

import com.mjc.own.domain.Test;
import com.mjc.own.model.strategy.demo.Context;
import com.mjc.own.model.template.TestA;
import com.mjc.own.model.template.TestB;
import com.mjc.own.model.template.TestTemplate;

public class Demo {


    public static void main(String[] args){
        TestTemplate testTemplate = new TestA();
        testTemplate.takerName("张三");

        TestTemplate testTemplate2 = new TestB();
        testTemplate2.takerName("张四");

        System.out.println(testTemplate.submit("A","B"));

        System.out.println(testTemplate2.submit("A","B"));
    }


}
