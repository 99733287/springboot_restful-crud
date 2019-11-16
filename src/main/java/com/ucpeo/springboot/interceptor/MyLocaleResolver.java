package com.ucpeo.springboot.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//国际化语言配置
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        if (!StringUtils.isEmpty(l)){
            String[] lan= l.split("_");
            Locale locale = new Locale(lan[0],lan[1]);
            System.out.println("使用用户定义语言");
            return  locale;

        }
        String client_lan = httpServletRequest.getHeader("Accept-Language");
        if (!StringUtils.isEmpty(client_lan))
        {
            String lan= client_lan.split(";")[0].split(",")[0];
            System.out.println(lan);
            if (!StringUtils.isEmpty(lan)){
                String[] local = lan.split("-");
                System.out.println("使用客户端语言！");
                return  new Locale(local[0],local[1]);
            }
        }
        System.out.println("使用服务器语言");
        return Locale.getDefault();
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
