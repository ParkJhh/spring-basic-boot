package com.kitri.springbasicboot.project.random_page;

import com.kitri.springbasicboot.lesson.mapping.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/random")
public class TestController {
    @GetMapping("/color")
    public String get(Model model){
        double random = Math.floor(Math.random() * 16777215);
        String randomColor = "#" + Integer.toHexString((int) random);

        model.addAttribute("Randomcolor",randomColor);
        return "/project/random_page/color";
    }
    @GetMapping("/number/{n}")
    @ResponseBody
    public String getStudent(@PathVariable int n){
        ArrayList<Integer> nInt = new ArrayList<>();
//        for(int i = 0; i <= n; i++){
//            nInt.add(i);
//        }
        int m = (int)(Math.random()*n);
        nInt.add(m);

        return "번호 : " + nInt;
    }
}
