package com.azure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.azure.dao")
public class SpringBootJasyptApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJasyptApplication.class, args);
    }

}
