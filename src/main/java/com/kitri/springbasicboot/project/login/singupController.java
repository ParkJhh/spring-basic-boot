package com.kitri.springbasicboot.project.login;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class singupController {

    static int id = 3;
    static HashMap<Integer, signupDto> userInfo = new HashMap<>();

    static {
        userInfo.put(1,new signupDto("kitri@naver.com","키트리","12345@!aaa"));
        userInfo.put(2,new signupDto("1234@naver.com","박준혁","qkrwnsgur1!"));
    }

    //초기 로그인화면
    @GetMapping
    public String signup(){
        return "redirect:/login/login.html";
    }
    //회원가입으로부터 폼 전송 받을 경우
    @PostMapping
    public String readForm(@Valid signupDto form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/login/signup.html";
        }
        //패스워드 불일치
        if(!form.password.equals(form.passwordChk)){
            return "redirect:/login/signup.html";
        }
        //이메일 있는 경우 찾기 위해 전체 순회
        for( Map.Entry<Integer, signupDto> entry : userInfo.entrySet() ){
            Integer key = entry.getKey();
            String email = entry.getValue().email;
            if(email.equals(form.email)){
                return "redirect:/login/signup.html";
            }
        }
        userInfo.put(id,new signupDto(form.email,form.name,form.password));
        id++;
        //성공시 연결
        return "redirect:/login/signupOk.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,HttpServletRequest req){
        //아이디 찾은후, 비밀번호도 같다면 통과
        for( Map.Entry<Integer, signupDto> entry : userInfo.entrySet() ){
            String emailChk = entry.getValue().email;
            String passwordChk = entry.getValue().password;
            if(emailChk.equals(email)){
                if(passwordChk.equals(password)){
                    HttpSession session = req.getSession();
                    session.setAttribute("sessionid",email);
                    return "redirect:/login/success.html";
                }
            }
        }
        //실패
        return "redirect:/login/fail.html";
    }

    @GetMapping("/logout")
    public String deleteSession(HttpServletRequest req){
        String name = (String) req.getSession().getAttribute("sessionid");
        if(name != null){
            //세션을 무효화한다
            req.getSession().invalidate();
            return "redirect:/login/login.html";
        }
        return "redirect:/login/after-login.html";
    }


}
