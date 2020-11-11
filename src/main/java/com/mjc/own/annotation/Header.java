package com.mjc.own.annotation;

/**
 * Created by gcb on 2019/6/28.
 */

import com.sun.tools.internal.xjc.model.CDefaultValue;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface Header {

    //互为别名 成对使用
    @AliasFor("name")
    String value() default "" ;

    @AliasFor("value")
    String name() default "" ;

    boolean required() default true ;

    String defaultValue() default "" ;

}
