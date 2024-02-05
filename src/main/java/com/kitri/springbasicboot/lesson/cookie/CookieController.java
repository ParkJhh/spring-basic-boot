package com.kitri.springbasicboot.lesson.cookie;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cookie")
public class CookieController {

    @PostMapping
    public String makeCookie1(HttpServletRequest req, HttpServletResponse resp){
        //서블릿용 쿠키생성
        Cookie cookie = new jakarta.servlet.http.Cookie("id",req.getParameter("id"));
        //쿠키의 만료기간 설정(기본 초단위 일주일로 하고싶다면 > 60 * 60 * 24 * 7)
//        cookie.setMaxAge(10);
        //쿠키를 응답에 추가
        resp.addCookie(cookie);
        return cookie.getValue();
    }
    @GetMapping
    public String readCookie(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("id")) return cookie.getValue();
        }
        return null;
    }
    //스프링의 쿠키 매핑
    //required 가 false일 경우, 쿠키가 없더라도 실행가능
    @GetMapping("/read")
    public String readCookie2(@CookieValue(name = "id",required = false) String id){
        return id;
    }

    //쿠키 삭제
    @DeleteMapping
    public void deleteCookie(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            //0초 후에 만료되도록 설정
            if(cookie.getName().equals("id")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
    }


}
