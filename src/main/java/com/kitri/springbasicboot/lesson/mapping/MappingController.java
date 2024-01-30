package com.kitri.springbasicboot.lesson.mapping;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MappingController {
    //ResponseBody를 붙이면, return 값을 ResponseBody에 넣겠다

    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "hello";
    }

    @GetMapping("/get2")
    public String get2(Model model){
        model.addAttribute("message","test2!");
        return "/lesson/mapping";
    }
    @GetMapping("/get3")
    public String get3(HttpServletRequest req){
        req.setAttribute("message","test3!");
        return "/lesson/mapping";
    }

    //
    @RequestMapping(value = "/get4", method = RequestMethod.GET )
    public ModelAndView get4(ModelAndView mv){
        mv.addObject("message","test4!");
        mv.setViewName("/lesson/mapping");
        return mv;
    }

    @RequestMapping(
            value = {"/a","/b","/c"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String multiURL(Model model){
        model.addAttribute("message","multi URL test!");
        return "/lesson/mapping";
    }

    @PostMapping("/post")
    public String post(Model model){
        model.addAttribute("message","POST test!");
        return "/lesson/mapping";
    }

    @PutMapping("/put")
    public String put(Model model){
        model.addAttribute("message","PUT test!");
        return "/lesson/mapping";
    }
    @DeleteMapping("/delete")
    public String delete(Model model){
        model.addAttribute("message","DELETE test!");
        return "/lesson/mapping";
    }
}
