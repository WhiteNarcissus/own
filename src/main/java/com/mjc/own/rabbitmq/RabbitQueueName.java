package com.example.help.rabbitmq;

public class RabbitQueueName {

    public static final String SUFFIX = "_queue";

    /**
     * use for coder to debug
     */

    public static final String DEBUG_PREFIX = "";

    //短信队列
    public static final String SMS_HANDlER_QUEUE =DEBUG_PREFIX +"sms_handler_queue";

    //主流程队列
    public static final String PROCESS_PRODUCT_QUEUE =DEBUG_PREFIX+ "process_product_queue";




}
