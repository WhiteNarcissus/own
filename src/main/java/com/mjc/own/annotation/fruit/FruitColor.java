package com.example.help.annotation.fruit;

/**
 * Created by gcb on 2019/6/28.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target(FIELD)
/**
 * 水果颜色注解
 */

@Retention(RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    public enum Color{ BLUE,RED,GREEN};

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;

}
