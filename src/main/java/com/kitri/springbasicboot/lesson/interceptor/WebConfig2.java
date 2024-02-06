//package com.kitri.springbasicboot.lesson.interceptor;
//
//import com.kitri.springbasicboot.lesson.filter.Log2Filter;
//import com.kitri.springbasicboot.lesson.filter.LogFilter;
//import jakarta.servlet.Filter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig2 implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LogInterceptor())
//                .addPathPatterns("/rsp/**");
//    }
//}
