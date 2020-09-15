package com.example.help.annotation;

/**
 * Created by gcb on 2019/6/28.
 */
public enum ElementType {
    TYPE,    //表明此注解可以用在类或接口上
    FIELD,     //表明此注解可以用在域上(还没用过，)
    METHOD,     //表明此注解可以用在方法上
    PARAMETER,     //表明此注解可以用在参数上
    CONSTRUCTOR,     //表明此注解可以用在构造方法上
    LOCAL_VARIABLE,     //表明此注解可以用在局部变量上
    ANNOTATION_TYPE,     //表明此注解可以用在注解类型上
    PACKAGE,
    TYPE_PARAMETER,     //类型参数声明
    TYPE_USE  //类型使用声明 (未使用过，也不知道怎么用)

}
