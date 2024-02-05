package com.kitri.springbasicboot.lesson.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {
    @PostMapping
    public String makeSeesion(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        session.setAttribute("id",req.getParameter("id"));
        return (String) session.getAttribute("id");
    }

    @GetMapping
    public String readSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (String) session.getAttribute("id");
    }
    //스프링의 세션
    @GetMapping("/read")
    public String readSession2(@SessionAttribute(name="id", required = false) String id){
        return id;
    }
    //세션 삭제 (로그아웃등)
    @DeleteMapping
    public void deleteSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session != null){
            //세션을 무효화한다
            session.invalidate();
        }
    }
}
