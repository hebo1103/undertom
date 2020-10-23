package com.example.demo.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author HB
 * @data 2020/10/23 15:07
 * @Description: 控制层
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * 注册自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorDemo()).addPathPatterns("/**");
    }
}
