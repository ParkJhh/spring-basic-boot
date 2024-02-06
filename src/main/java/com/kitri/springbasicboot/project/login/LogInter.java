package com.kitri.springbasicboot.project.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInter implements HandlerInterceptor {
    //리턴 true일때 체이닝
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name = (String) request.getSession().getAttribute("sessionid");
        if(name != null){
            return true;
        }
        response.sendRedirect("http://localhost:8080/login/shutdown.html");
        return false;
    }
}