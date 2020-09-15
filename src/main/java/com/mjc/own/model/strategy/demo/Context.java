package com.example.help.model.strategy.demo;

public class Context {
    Strategy sc = null ;

    public  Context(String type){
        switch (type){
            case "+" :
               SumStrategy ss = new SumStrategy() ;
               sc = ss;
               break;
            case "-" :
                CutStrategy cs = new CutStrategy();
                sc = cs ;
                break;

        }
    }


    Integer executeStrategy(int a ,int b ){
     return  sc.doOperation(a,b);
    }



    //客户端可以通过下拉列表控制 策略 1.0的时候

    public static void main(String[] args){
        //客户端
        Context  c = new Context("+");
        System.out.println(c.executeStrategy(1,1));

    }
}
