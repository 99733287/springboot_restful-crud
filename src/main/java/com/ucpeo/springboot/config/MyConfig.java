package com.ucpeo.springboot.config;

import com.ucpeo.springboot.interceptor.LoginHandlerInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
// 不完全接管MVC 配置 选择实现 WebMvcConfigurer接口即可
@Configuration
public class MyConfig implements WebMvcConfigurer {

//    添加视图控制
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

// 添加拦截器  以及排除请求路径
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login", "/asserts/**", "/res/**", "/webjars/bootstrap/**");
    }




}
