package com.example.help.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gcb on 2018/12/19.
 * 此类为全局统一返回的returnObject
 */
public class ReturnObject<T> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    //状态码
    private Code code ;
    //返回的提示信息
    private String msg ;

    //分页所需数据
    private Integer total = 20 ;
    private  T rows ;



    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }
    /**
     本次数据 使用bootstrap-table 作为前端数据渲染
     所以必须 返回 两个参数 total 和 rows json 格式如下
     缺少一个 都数据都会报错

     {
     "total": 200,
     "rows": [
     {
     "id": 0,
     "name": "Item 0",
     "price": "$0"
     },
     {
     "id": 1,
     "name": "Item 1",
     "price": "$1"
     }
     ]
     }
     */

}
