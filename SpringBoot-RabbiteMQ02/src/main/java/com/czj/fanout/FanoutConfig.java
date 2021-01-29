package com.czj.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    //创建两个队列
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout2");
    }


    //创建两个交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return  new FanoutExchange("fanoutExchange");
    }

    //将两个队列绑定到交换机上
    @Bean
    public Binding binding1(){
        return  BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2(){
        return  BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

}
