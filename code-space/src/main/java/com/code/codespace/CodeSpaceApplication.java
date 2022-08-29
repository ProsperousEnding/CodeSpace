package com.code.codespace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@ComponentScan(value = "com.code.*")
@MapperScan("com.code.*")
@EnableSwagger2
public class CodeSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeSpaceApplication.class, args);
    }

}
