package com.lyl.springboot.ossd.utils.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

// 添加拦截器
// @Configuration
public class ApiConfig extends WebMvcConfigurationSupport {

    private final CorsInterceptor corsInterceptor;

    @Autowired
    public ApiConfig(CorsInterceptor corsInterceptor) {
        this.corsInterceptor = corsInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}

