package com.kitri.springbasicboot.project.rsp_game;

import com.kitri.springbasicboot.project.todo.Todo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/rsp")
public class RspApiController {
    //초기값 세팅
    Count count = new Count();
    @GetMapping("/x")
    public Count First() {
        return count;
    }
    //세션생성
    @GetMapping
    public String readSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (String) session.getAttribute("id");
    }
    
    //세션 종료시 초기화(ex연결종료등)
    @DeleteMapping("")
    public Count deleteSession(@SessionAttribute(name="id", required = false) String id){
        if(id != null){
            id = null;
        }
        return new Count(0,0,0);
    }
}
