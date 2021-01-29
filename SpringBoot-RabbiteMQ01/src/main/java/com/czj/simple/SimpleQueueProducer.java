package com.czj.simple;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleQueueProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public  void send(){
        System.out.println("SimpleQueueProducer");

        //发送消息，第一个参数为队列名称，第二参数为消息内容
        rabbitTemplate.convertAndSend("simpleQueue","简单模式");
    }
}
