package com.czj;

import com.czj.simple.SimpleQueueProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRabbiteMq01ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private SimpleQueueProducer simpleQueueProducer;

    @Test
    public void testSimpleQueue(){
        for (int i = 0; i < 4; i++){
            simpleQueueProducer.send();

        }
    }

}
