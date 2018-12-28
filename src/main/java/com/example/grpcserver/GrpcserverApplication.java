package com.example.grpcserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.grpcserver.dao")
public class GrpcserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcserverApplication.class, args);
    }

}

