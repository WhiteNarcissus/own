package com.mjc.own.rabbitmq;

public class RabbitQueueName {

    public static final String SUFFIX = "_queue";

    /**
     * use for coder to debug
     */

    public static final String DEBUG_PREFIX = "";

    //短信队列 （程序队列 执行完程序之）
    public static final String SMS_HANDlER_QUEUE =DEBUG_PREFIX +"sms_handler_queue";

    public static final String PROCESS_PRODUCT_QUEUE =DEBUG_PREFIX+ "process_product_queue";

    //节点处理队列（操作中心处理队列 规定下一节点去哪）
    public static final String OC_QUEUE =DEBUG_PREFIX+ "oc_queue";

    //异常队列 （异常队列）
    public static final String ERO_QUEUE =DEBUG_PREFIX+ "ero_queue";


}
