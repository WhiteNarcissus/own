package com.mjc.own.rabbitmq;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by gcb on 2019/4/24.
 *
 */
@Configuration
public class RabbitConfig {

    public static final String TOPIC_EXCHANGE = "topicExchange";
    public static final String PROCESS_TOPIC_EXCHANGE = "processTopicExchange";
    public static final String SMS_TOPIC_EXCHANGE = "smsTopicExchange";

    @Autowired
    private Environment env;


    //demo 没有指定交换机
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue smsQueue() {
        return new Queue(env.resolvePlaceholders(RabbitQueueName.SMS_HANDlER_QUEUE));
    }


    @Bean
    public Queue processQueue() {
        return new Queue(env.resolvePlaceholders(RabbitQueueName.PROCESS_PRODUCT_QUEUE));
    }


    @Bean
    public TopicExchange smsExchange() {
        return new TopicExchange(SMS_TOPIC_EXCHANGE);
    }

    @Bean
    public TopicExchange proceExchange() {
        return new TopicExchange(PROCESS_TOPIC_EXCHANGE);
    }

    /**
     * @return
     * Binding binding = BindingBuilder.bind(queue).to(exchange).with(routing_key);
     *
     */
    @Bean
    public Binding smsBing() {
        return  BindingBuilder.bind(smsQueue()).to(smsExchange())
                .with(env.resolveRequiredPlaceholders(RabbitQueueName.SMS_HANDlER_QUEUE));
    }

    @Bean
    public Binding processBing() {
        return  BindingBuilder.bind(processQueue()).to(proceExchange())
                .with(env.resolveRequiredPlaceholders(RabbitQueueName.SMS_HANDlER_QUEUE));
    }







}
