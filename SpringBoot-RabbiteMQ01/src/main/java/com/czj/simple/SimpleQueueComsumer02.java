package com.czj.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "simpleQueue")
public class SimpleQueueComsumer02 {

    @RabbitHandler
    public  void recieve(String content){
        System.out.println("SimpleQueueComsumer");
        System.out.println("来自SimpleQueueProducer的消息02："+content);
    }
}
