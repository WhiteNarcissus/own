package com.example.help.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /*
    * 获取当前日期时间
    * */
    public static Timestamp getTimestamp(){
       SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =new Date();
        return  Timestamp.valueOf(simpleDate.format(date));
        //return  new Timestamp(date.getTime());

    }

    public static String getYyyyMMddHHmmss(){
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date =new Date();
        return simpleDate.format(date);
    }


}
