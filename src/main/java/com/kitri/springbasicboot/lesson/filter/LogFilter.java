package com.kitri.springbasicboot.lesson.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
    //doFilter는 무조건 구현해야 한다
    //Slf4j > 내장된
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("로그 메시지 : doFilter() 호출됨");
        chain.doFilter(request,response);
    }
    //초기화
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("로그 메시지 : init() 호출됨");
    }
    //소멸
    @Override
    public void destroy() {
        log.info("로그 메시지 : destory() 호출됨");
    }
}
