package com.mjc.own.rabbitmq.demo.handler;

import com.mjc.own.annotation.Payload;
import com.mjc.own.rabbitmq.demo.pojo.Program;
import com.mjc.own.rabbitmq.demo.sender.ProgramSender;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

import java.util.List;

/**
不同programtype的programhandler ，不同子类监听不同的 program type队列
  根据程序类型发送到 处理对应程序的队列
 */

public abstract class BaseProgramHandler {

    private ProgramSender programSender ;


    protected void  execute0(Program program){}



    //这个方法是根据拿到不同的program 来做
    public abstract void execute(@Payload Program program, Channel channel) ;


    public List<Program> getPrograms(String nodeCode){
        List<Program> programList ;
        return null ;
    }

    public Program msgValidate(Object msg){

        List<Program> programList ;
        return  null ;
    }

}
