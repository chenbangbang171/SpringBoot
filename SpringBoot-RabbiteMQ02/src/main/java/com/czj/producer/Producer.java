package com.czj.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public  void send(){
        System.out.println("FanoutProducer");

        rabbitTemplate.convertAndSend("fanoutExchange","","发布订阅");
    }
}
