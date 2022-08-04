package com.code.codespace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(value = "com.iflytek")
@MapperScan("com.code")
public class CodeSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeSpaceApplication.class, args);
    }

}
