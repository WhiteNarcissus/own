package com.example.help.jdk8;

import com.example.help.domain.User;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gcb on 2019/6/3.
 * Stream_ 不是集合元素，它不是数据结构并不保存数据，它是有关算法和计算的，它更像一个高级版本的 Iterator。
 * 对 Stream_ 的使用就是实现一个 filter-map-reduce 过程，产生一个最终结果，或者导致一个副作用（side effect )
 *
 */
public class Stream_ {



    public static void  main(String[] args){

        //这是特殊流的三种创建方式吗
        Stream stream = Stream.of("a","b","c");
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        List<String> list = Arrays.asList(strArray);
        stream = list.stream();


        //stream 使用一次就结束, 这个是比较常用的方式
        List list2 = new ArrayList();
        stream = list2.stream();



        // map/flatMap 它的作用就是把 input Stream 的每一个元素，映射成 output Stream 的另外一个元素。

         List<String>  inputList = new ArrayList<>();
         inputList.add("x");
         inputList.add("y");
         inputList.add("z");
         List<String> upList =inputList.stream().map(String::toUpperCase).collect(Collectors.toList());
         System.out.println(upList.toString());

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println("输出squareNums---------"+squareNums);

        // flatMap 一对多 进行映射flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        System.out.println("输出inputStream-----"+inputStream.toString());
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());



        // filter 对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);




        // forEach 方法接收一个 Lambda 表达式，然后在 Stream 的每一个元素上执行该表达式。 forEach 是为 Lambda 而设计的


        List<User>  roster = new ArrayList<>();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u4 = new User();
        u1.setStuId("a");
        u2.setStuId("a");
        u3.setStuId("a");
        u4.setStuId("b");


        roster.add(u1);
        roster.add(u2);
        roster.add(u3);
        roster.add(u4);
        // Java 8
        roster.stream()
                .filter(p -> p.getStuId() == "b")
                .forEach(p -> System.out.println(p.getStuId()));
        // Pre-Java 8
        for (User p : roster) {
            if (p.getStuId() == "b") {
                System.out.println(p.getStuId());
            }
        }

        System.out.println(evens.toString());

        //进阶篇 Stream.generate通过实现 Supplier 接口，你可以自己来控制流的生成。这种情形通常用于随机数、常量的 Stream，或者需要前后元素间维持着某种状态信息的 Stream。
        // 把 Supplier 实例传递给 Stream.generate() 生成的 Stream，默认是串行（相对 parallel 而言）但无序的（相对 ordered 而言）。由于它是无限的，在管道中，必须利用 limit 之类的操作限制 Stream 大小
        //


        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);

        // 自我实现 Supplier
        Stream.generate(new UserSupplier()).
                limit(10).
                forEach(p -> System.out.println(p.getStuId() + ",,, " + p.getUserMessage()));




        //进阶篇 用 Collectors 来进行 reduction 操作。 groupingBy/partitioningBy 分组

        Map<Integer, List<User>> personGroups = Stream.generate(new  UserSupplier()).
                limit(100).
                collect(Collectors.groupingBy(User::getUserMessage));
        Iterator it = personGroups.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<User>> persons = (Map.Entry) it.next();
            System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
        }


        // 自定义

//        Stream.generate(roster).
//                limit(100).collect(Collectors.groupingBy(User::getUserMessage));




        //综上 我认为 Stream  是算法 是计算 是函数。




    }







}
