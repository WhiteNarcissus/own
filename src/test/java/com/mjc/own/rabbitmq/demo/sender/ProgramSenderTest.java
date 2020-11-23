package com.mjc.own.rabbitmq.demo.sender;

import com.mjc.own.rabbitmq.RabbitConfig;
import com.mjc.own.rabbitmq.RabbitQueueName;
import com.mjc.own.rabbitmq.demo.pojo.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class ProgramSenderTest {
    @Autowired
    private ProgramSender programSender ;
    @Autowired
    private RabbitmqSender rabbitmqSender ;
    @Test
    public void sendToNodeQueue() {

        //rabbitmqSender.convertAndSend(RabbitConfig.OC_TOPIC_EXCHANGE, RabbitQueueName.OC_QUEUE,"zhans222 ");
        Task task = new Task();
        task.setNodeCode("sss");
        programSender.sendToNodeQueue(task);
    }
}