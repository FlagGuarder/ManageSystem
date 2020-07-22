package com.text_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.text_project.dao")
public class TextProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextProjectApplication.class, args);
    }

}
