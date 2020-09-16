package com.mjc.own.jdk8;

import com.mjc.own.domain.User;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by gcb on 2019/6/4.
 */
public class UserSupplier implements Supplier<User> {

    private int index = 0;
    private Random random = new Random();
    @Override
    public User get() {
        return new User(""+index++, random.nextInt(100));
    }




}
