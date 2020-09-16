package com.mjc.own.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class ExceptionHandle {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //处理自定义的异常
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ReturnObject handler(MyException e){
        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(e.getCode());
        returnObject.setMsg(e.getCode().getName());

        return returnObject;
    }


}