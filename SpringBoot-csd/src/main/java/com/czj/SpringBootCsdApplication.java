package com.czj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czj.mapper")
public class SpringBootCsdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCsdApplication.class, args);
    }

}
