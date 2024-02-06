package com.kitri.springbasicboot.lesson.valid;

import com.kitri.springbasicboot.lesson.valid.dto.SingUpFormDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/valid")
public class validController {
    @GetMapping
    public String form(){
        return "redirect:/valid/form.html";
    }
    //dto에 설정된 valid를 여기서 읽어들인다
    @PostMapping
    public String readForm(@Valid SingUpFormDto form){
        System.out.println(form);
        return "redirect:/valid/success.html";
    }


}
