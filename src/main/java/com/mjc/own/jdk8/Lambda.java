package com.mjc.own.jdk8;




import com.mjc.own.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by gcb on 2019/6/3.
 * 开始学习 jdk8 表达式 函数编程 （先 考虑定义参数  在考虑是实现）
 * 第一个 接口函数 Consumer 消费没有返回值 没啥用
 */
public class Lambda {




      public static void  main(String[] args){
          User u = new User();

          User  u2= new User();



          u.setStuId("1");
          u2.setStuId("2");



          // Consumer
          // 自己写参数类型
          Consumer<User> c = (User a) -> a.setStuId(a.getStuId().concat(a.getStuId()));

          //根据上下文 自己判断参数类型
          Consumer<User> c2 = a -> a.setStuId(a.getStuId().concat(a.getStuId()));
          c.accept(u);
          c.accept(u2);
          System.out.println( u.getStuId()+ ":"+u2.getStuId());


          //Function<T,R>
          //自己写参数
          Function<Integer ,Integer>  f =  (Integer i) -> {return  i+1; };

          Function<Integer ,Integer> f2 = i ->i+1 ;


          f.andThen(f.andThen(f)).apply(2);
          f2.andThen(f2.andThen(f2)) ;
          System.out.println( f.apply(2)+ ": Function<T,R> : "+f2.apply(3));

          System.out.println( f.andThen(f.andThen(f)).apply(0)   );

          //BiFunction<T,U,R> 带两个参数的 函数
          BiFunction<Integer ,Integer,Integer> bf =  (Integer i , Integer x) -> {return  i+x+1; };
          Integer z =  bf.apply(1,2);
          System.out.println(z);



          //操作集合
          List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
          long num = list.stream().filter( a ->  a > 4 ).count();
          System.out.println(num);



          //compose :先这个  andThen：待会再这个
          Function<Integer,Integer> A=i->i+1;
          Function<Integer,Integer> B=i->i*i;
          System.out.println("F1:"+B.apply(A.apply(5)));
          System.out.println("F1:"+B.compose(A).apply(5));
          System.out.println("F2:"+B.andThen(A).apply(5));






      }






}
