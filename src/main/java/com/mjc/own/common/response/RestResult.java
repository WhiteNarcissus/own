package com.mjc.own.common.response;

import java.io.Serializable;
import java.util.HashMap;

public class RestResult<T> implements Serializable {
    private int code;
    private String message;

    private T payload;

    public RestResult() {
    }

    public RestResult(T object) {

    }

    public RestResult(int code, String msg, T object) {

    }

    public static <T> RestResult build(){
        return new RestResult();
    }
    public static <T> RestResult success(){
        RestResult result = new RestResult();
        result.setCode(RsultCode.SUCCESS.getValue());
        result.setMessage(RsultCode.SUCCESS.getName());
        result.setPayload(new HashMap());
        return result;
    }

    public static <T> RestResult success(T t){
        RestResult result = success();
        result.setPayload(t);
        return result;
    }

    public RestResult code (int code){
        this.setCode(code);
        return this;
    }
    public RestResult msg(String message){
        this.setMessage(message);
        return this;
    }
    public RestResult payload(T payload){
        this.setPayload(payload);
        return this;
    }

    //=================

    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
