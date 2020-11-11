package com.mjc.own.suanfa.bloom.demo;

import com.mjc.own.model.template.TestA;
import com.mjc.own.model.template.TestB;
import com.mjc.own.model.template.TestTemplate;
import com.mjc.own.suanfa.bloom.MyBloomFilter;

public class Demo {


    public static void main(String[] args){
        String a ="今天可真开心錒";
        String b ="今天非常开心";
        String c ="今天可真开心錒";

        MyBloomFilter myBloomFilter = new MyBloomFilter();
        System.out.println(myBloomFilter.contains(a));
        System.out.println(myBloomFilter.contains(b));
        System.out.println(myBloomFilter.contains(c));
        myBloomFilter.add(a);
        myBloomFilter.add(b);
        myBloomFilter.add(c);
        System.out.println(myBloomFilter.contains(a));
        System.out.println(myBloomFilter.contains(b));
        System.out.println(myBloomFilter.contains(c));

        //String 的哈希code 是通过 String 类的散列值就是依次遍历其每个字符成员，
        // 递归的将当前得到的hashCode乘以31然后加上下一个字符成员的ASCII值（h = 31 * h + val[i];）
        //List集合的hashcode则是将每个元素hashCode乘以31+个元素的

        Object d = new Object();
        d.hashCode();
    }
}
