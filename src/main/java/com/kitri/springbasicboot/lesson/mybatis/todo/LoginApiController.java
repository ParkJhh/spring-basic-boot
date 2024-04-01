package com.kitri.springbasicboot.lesson.mybatis.todo;

import com.kitri.springbasicboot.lesson.mybatis.dto.Member;
import com.kitri.springbasicboot.lesson.mybatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.mybatis.dto.ResponseTodo;
import com.kitri.springbasicboot.lesson.mybatis.mappers.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/login")
public class LoginApiController {
    @Autowired
    TodoMapper todoMapper;

    @PostMapping
    public Long login(@RequestBody Member member){
        ArrayList<Member> finduser = (ArrayList<Member>) todoMapper.loignchechk();

        for(Member members : finduser){
            Long getId = members.getMemberid();
            String emailChk = members.getEmail();
            String passwordChk = members.getPassword();
//            String name = members.getName();

            if(member.getEmail().equals(emailChk)){
                if(member.getPassword().equals(passwordChk)){
                    return getId;
                }
            }
        }
        return null;
    }
}
