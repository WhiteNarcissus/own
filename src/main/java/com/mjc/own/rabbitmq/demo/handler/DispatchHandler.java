package com.mjc.own.rabbitmq.demo.handler;


import com.mjc.own.annotation.Header;
import com.mjc.own.annotation.Payload;
import com.mjc.own.rabbitmq.RabbitQueueName;
import com.mjc.own.rabbitmq.demo.pojo.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;

import java.nio.channels.Channel;

//节点分发类
public class DispatchHandler extends BaseProgramHandler {

    private final static Logger logger = LoggerFactory.getLogger(DispatchHandler.class);

    @RabbitListener(queues = RabbitQueueName.OC_QUEUE)
    public void listen(@Payload Task task,
                       @Header long deliverTag,
                       @Header(value = AmqpHeaders.MESSAGE_ID, defaultValue = "") String messageId,
                       Channel channel) {
        logger.info("mqName:{} ,接受消息，caseId：{}，nodeCode：{},messageId:{}", RabbitQueueName.OC_QUEUE, task.getCaseId(), task.getNodeCode(), messageId);

        try {
            handlerTask(task);
        } catch (Exception e) {

        }


    }


    private void handlerTask(Task task){

        System.out.println(task);

    }


}


