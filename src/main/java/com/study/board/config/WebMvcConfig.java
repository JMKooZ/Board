package com.study.board.config;

import com.study.board.interceptor.LoggerInterceptor;
import com.study.board.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
            .excludePathPatterns("/css/**", "/images/**", "/js/**","/font/**");

        registry.addInterceptor(new LoginCheckInterceptor())
            .addPathPatterns("/**/*.do")
            .excludePathPatterns("/log*");
    }
}
