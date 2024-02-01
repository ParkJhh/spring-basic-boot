package com.kitri.springbasicboot.lesson.reqres;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/countries")
public class ReqResController {
    //국가, 수도를 찾아 반환하기

    static HashMap<String,String> countries = new HashMap<>();
    static {
        countries.put("한국","서울");
        countries.put("미국","워싱턴D.C");
        countries.put("프랑스","파리");
        countries.put("몽골","울란바토르");
        countries.put("아르헨티나","부에노스아이레스");
    }
static HashMap<String,Country> countries2 = new HashMap<>();
    static {
        countries2.put("한국",new Country("한국","서울"));
        countries2.put("미국",new Country("미국","워싱턴D.C"));
        countries2.put("프랑스",new Country("프랑스","파리"));
        countries2.put("몽골",new Country("몽골","울란바토르"));
        countries2.put("아르헨티나",new Country("아르헨티나","부에노스아이레스"));
    }
    
    @GetMapping("/{name}")
    public String searchCapital(@PathVariable String name, Model model){
        String capital = countries.get(name);
        if(capital == null){
            throw new RuntimeException("찾으려는 국가가 없습니다");
        }
        model.addAttribute("name",name);
        model.addAttribute("capital",capital);
        return "/lesson/countries";
    }

    @GetMapping("/searchCapital")
    public String searchCapital2(@RequestParam String name , Model model){
        String capital = countries.get(name);
        if(capital == null){
            throw new RuntimeException("찾으려는 국가가 없습니다");
        }
        model.addAttribute("name",name);
        model.addAttribute("capital",capital);

        return "/lesson/countries";
    }

    @PostMapping("/addCountry")
    public String addCountry(@RequestParam String name, @RequestParam String capital){
        countries.put(name,capital);
        //리다이렉트
        return "redirect:http:/localhost:8080/lesson/countries/searchCapital?name=" + name;
    }

    @PostMapping("/addCountry2")
    public void addCountry2(@RequestBody Country country){
        countries2.put(country.getName(), country);
        }
}
