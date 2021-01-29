package com.czj.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout2")
public class Customer02 {

    @RabbitHandler
    public void receive(String content){
        System.out.println("customer2:"+content);
    }
}
