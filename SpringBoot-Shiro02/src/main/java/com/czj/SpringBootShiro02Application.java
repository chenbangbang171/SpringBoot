package com.czj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czj.mapper")

public class SpringBootShiro02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShiro02Application.class, args);
    }

}
