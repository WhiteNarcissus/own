package com.mjc.own.rabbitmq.demo.sender;

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
    @Test
    public void sendToNodeQueue() {
       Task task = new Task();
       task.setNodeCode("CS1");
       programSender.sendToNodeQueue(task);
    }
}