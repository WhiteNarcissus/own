package com.mjc.own.rabbitmq.demo.sender;

import com.mjc.own.rabbitmq.demo.pojo.ProgramConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ProgramSender {
    private static final Logger logger = LoggerFactory.getLogger(ProgramSender.class);
    public static final String QUEUE_SEND_MSG_TO = "[QUEUE] Send msg to ---->" ;
    public static final String QUEUE_FINISHED = "[QUEUE] Finished" ;

    private static Environment env ;

    @Autowired
    public void set(Environment env ){
        ProgramSender.env = env ;
    }
    @Resource
    private RabbitmqSender rabbitmqSender ;

    /**
     * 发送到程序队列
     * @param program
     */
   public void sendToProgramHandlerQueue(){


   }


}
