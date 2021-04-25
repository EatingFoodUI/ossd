package com.lyl.springboot.ossd.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 文件访问配置类
@Configuration
public class FileAccessConfig implements WebMvcConfigurer {
    // 头像上传路径
    @Value("${PersonPit.addr}")
    private String UPLOAD_FOLDER;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("doing 头像路径 文件映射");
        // 头像路径 文件映射 前端访问路径
        System.out.println("file:"+ UPLOAD_FOLDER);
        registry.addResourceHandler("/PersonPit/**").addResourceLocations("file:"+ UPLOAD_FOLDER);
    }
}
