package com.mjc.own.rabbitmq.demo.sender;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Service;


@Service
public class RabbitmqSender {
    private static final Logger logger = LoggerFactory.getLogger(RabbitmqSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 指定交换机
     */
    public  void  convertAndSend(String exchange ,String queueName ,Object object){
        Message message =makeMessage(queueName,object) ;
        amqpTemplate.convertAndSend(exchange,queueName,message);
        logger.info("{} FINISHED" ,queueName);
    }
    /**
     * 不指定交换机
     */

    public  void  convertAndSend(String queueName ,Object object){
        Message message =makeMessage(queueName,object) ;
        amqpTemplate.convertAndSend(queueName,message);
        logger.info("{} FINISHED" ,queueName);
    }

    private Message makeMessage(String queueName ,Object object){
        String messageId = String.valueOf(UuidUtil.getTimeBasedUuid());
        logger.info(" Send to ===>[{}] ,messageId:[{}]",queueName,messageId);
        MessageConverter messageConverter = new SimpleMessageConverter();
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setMessageId(messageId);
        Message message = messageConverter.toMessage(object,messageProperties);
        return  message ;
    }
}
