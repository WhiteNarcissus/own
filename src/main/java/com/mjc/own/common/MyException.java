package com.mjc.own.common;

public class MyException extends RuntimeException {


    private Code code;//状态码
    public MyException(String message, Code code) {
        super(message);
        this.code = code;
    }
    public Code getCode() {
        return code;
    }


}
