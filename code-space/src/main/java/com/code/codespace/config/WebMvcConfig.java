package com.code.codespace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: WebMvcConfig
 * @Description: 解决跨域问题
 * @Author hlfang4
 * @Date: 2022/08/08 15:08
 */
@Component
public class WebMvcConfig {
    @Bean
    public WebMvcConfigurer MyWebMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //放行哪些原始域
                        .allowedOrigins("*")
                        .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                        .allowedHeaders("*")
                        .exposedHeaders("*");
            }
        };
}
}
