package com.lyl.springboot.ossd.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 */
@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // SpringBoot2.4.0 [allowedOriginPatterns]代替[allowedOrigins]
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
