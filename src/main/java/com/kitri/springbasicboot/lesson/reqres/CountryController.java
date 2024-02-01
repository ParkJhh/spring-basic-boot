package com.kitri.springbasicboot.lesson.reqres;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/countries")
public class CountryController {
    static HashMap<String,Country> countries = new HashMap<>();
    static {
        countries.put("한국",new Country("한국","서울"));
        countries.put("미국",new Country("미국","워싱턴D.C"));
        countries.put("프랑스",new Country("프랑스","파리"));
        countries.put("몽골",new Country("몽골","울란바토르"));
        countries.put("아르헨티나",new Country("아르헨티나","부에노스아이레스"));
    }
    @GetMapping
    public ArrayList<Country> countries(){
        return new ArrayList<>(countries.values());
    }

//    @PostMapping("")
    //json 형식 외에 방식으로 데이터를 전송하는 경우
    public Country addCountry(@RequestParam String name, @RequestParam String capital){
        countries.put(name, new Country(name,capital));
        return countries.get(name);
    }

//    @PostMapping("")
    //json 형식으로 데이터를 전송하는 경우
    public String addCountry2(@RequestBody Country country){
        countries.put(country.getName(), country);
        return "redirect:/countries";
    }
    //json 형식이 아닌 것을 받아 객체화 하여 form태그등으로 보내는 경우
    @PostMapping("")
    public Country addCountry3(@ModelAttribute Country country){
        countries.put(country.getName(), country);
        return countries.get(country.getName());
    }

    @PostMapping("/4")
    public ResponseEntity<Country> addCountry(@ModelAttribute Country country){
        countries.put(country.getName(), country);
        return ResponseEntity.ok(countries.get(country.getName()));
    }
}
