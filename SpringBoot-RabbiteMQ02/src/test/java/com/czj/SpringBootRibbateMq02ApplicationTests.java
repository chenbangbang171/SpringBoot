package com.czj;

import com.czj.producer.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRibbateMq02ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private Producer producer;
    @Test
    public void fanoutTest(){
        producer.send();
    }
}
