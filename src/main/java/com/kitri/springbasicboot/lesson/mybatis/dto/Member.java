package com.kitri.springbasicboot.lesson.mybatis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    Long memberid;
    String email;
    String name;
    String password;

    public Member(Long getId, String emailChk, String passwordChk, String name) {
    }
}
