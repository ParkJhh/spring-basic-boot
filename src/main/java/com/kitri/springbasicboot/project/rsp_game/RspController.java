package com.kitri.springbasicboot.project.rsp_game;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rsp")
public class RspController {
    //api로 넘겨주기
    @GetMapping
    public String home() {
        return "/project/rsp_game/rsp";
    }


    //연결 종료시
//    @DeleteMapping
//    public void deleteSession(@SessionAttribute(name="id", required = false) String id)){
//        return id;
//    }
}