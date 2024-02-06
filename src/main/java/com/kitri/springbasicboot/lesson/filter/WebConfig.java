//package com.kitri.springbasicboot.lesson.filter;
//
//import com.kitri.springbasicboot.lesson.interceptor.LogInterceptor;
//import jakarta.servlet.Filter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    //세부적인 설정시에는 implements WebMvcConfigurer 로 설정한다
//    public FilterRegistrationBean logFilter(){
//        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new LogFilter());
//        filterRegistrationBean.setOrder(2);
//
//        return filterRegistrationBean;
//    }
//
//    public FilterRegistrationBean log2Filter(){
//        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new Log2Filter());
//        filterRegistrationBean.setOrder(1);
//
//        return filterRegistrationBean;
//    }
//}
