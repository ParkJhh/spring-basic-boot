package com.kitri.springbasicboot.lesson.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    //중복된 컴포넌트를 구분하기 위해, 한정자(Qualifier)를 통해 누구를 쓸지 지정한다.
    @Qualifier("englishGreeting")
    @Autowired
    Greeting greeting;

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", greeting.hello());
        return "greeting";
    }

}