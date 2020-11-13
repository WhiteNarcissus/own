package com.mjc.own.rabbitmq.demo.sender;

import com.mjc.own.rabbitmq.RabbitConfig;
import com.mjc.own.rabbitmq.RabbitQueueName;
import com.mjc.own.rabbitmq.demo.pojo.Program;
import com.mjc.own.rabbitmq.demo.pojo.ProgramConfiguration;
import com.mjc.own.rabbitmq.demo.pojo.Task;
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
   public void sendToProgramHandlerQueue(Program program){

       String programType = program.getProgramType();
       String queueName = env.resolveRequiredPlaceholders(env.resolveRequiredPlaceholders(RabbitQueueName.DEBUG_PREFIX+programType));
        rabbitmqSender.convertAndSend(RabbitConfig.PROCESS_TOPIC_EXCHANGE,queueName,program);
   }

    /**
     * 发送到节点队列
     * @param task
     */
    public void sendToNodeQueue(Task task ){
        String queueName = env.resolveRequiredPlaceholders(env.resolveRequiredPlaceholders(RabbitQueueName.OC_QUEUE));
        rabbitmqSender.convertAndSend(RabbitConfig.OC_TOPIC_EXCHANGE,queueName,task);
    }

    /**
     * 发送到差错队列
     * @param
     */
    public void sendToEroQueue(String erro){
      rabbitmqSender.convertAndSend(RabbitConfig.ERO_TOPIC_EXCHANGE,erro);
    }

    /**
     * 发送到结束队列
     * @param task
     */
    public void sendToEndQueue(Task task){
        String queueName = env.resolveRequiredPlaceholders(env.resolveRequiredPlaceholders(RabbitQueueName.PROCESS_PRODUCT_QUEUE));
        rabbitmqSender.convertAndSend(RabbitConfig.OC_TOPIC_EXCHANGE,queueName,task);

    }


}
