package com.ucpeo.springboot;


import com.ucpeo.springboot.interceptor.LoginHandlerInterceptor;
import com.ucpeo.springboot.interceptor.MyLocaleResolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }

}
