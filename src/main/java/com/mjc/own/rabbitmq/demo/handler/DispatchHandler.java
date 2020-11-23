package com.mjc.own.rabbitmq.demo.handler;


import com.mjc.own.annotation.Header;
import com.mjc.own.annotation.Payload;
import com.mjc.own.rabbitmq.RabbitQueueName;
import com.mjc.own.rabbitmq.demo.pojo.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

//节点分发类
@Component
public class DispatchHandler extends BaseProgramHandler {

    private final static Logger logger = LoggerFactory.getLogger(DispatchHandler.class);

    @RabbitListener(queues = RabbitQueueName.OC_QUEUE)
    public void listen(@Payload Task task,
                       Channel channel) {
        logger.info("mqName:{} ,接受消息，caseId：{}，nodeCode：{},messageId:{}", RabbitQueueName.OC_QUEUE, task.getCaseId(), task.getNodeCode());

        try {
            handlerTask(task);
        } catch (Exception e) {

        }


    }


    @RabbitListener(queues = RabbitQueueName.OC_QUEUE)
    public void listen(@Payload String task,
                       Channel channel) {
      //  logger.info("mqName:{} ,接受消息，caseId：{}，nodeCode：{},messageId:{}", RabbitQueueName.OC_QUEUE, task.getCaseId(), task.getNodeCode(), messageId);

        try {
            System.out.println(task+"1111");
        } catch (Exception e) {

        }


    }


    private void handlerTask(Task task){

        System.out.println(task+"1111");

    }


}


