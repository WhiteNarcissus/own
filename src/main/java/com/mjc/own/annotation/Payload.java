package com.mjc.own.annotation;

/**
 * Created by gcb on 2019/6/28.
 */

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.PARAMETER ,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Payload {

    //互为别名 成对使用
    @AliasFor("expression")
    String value() default "" ;

    @AliasFor("value")
    String expression() default "" ;

    boolean required() default true ;

}
