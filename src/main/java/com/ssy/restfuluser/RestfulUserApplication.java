package com.ssy.restfuluser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssy.restfuluser.dao")
public class RestfulUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulUserApplication.class, args);
    }

}
