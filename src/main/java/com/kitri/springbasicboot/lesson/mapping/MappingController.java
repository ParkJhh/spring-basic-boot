package com.kitri.springbasicboot.lesson.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MappingController {
    //ResponseBody를 붙이면, return 값을 ResponseBody에 넣겠다

    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "hello";
    }

    @GetMapping("/get2")
    public String get2(){

    }
}
