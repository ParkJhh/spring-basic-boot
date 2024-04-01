package com.kitri.springbasicboot.lesson.mybatis.mappers;

import com.kitri.springbasicboot.lesson.mybatis.dto.Member;
import com.kitri.springbasicboot.lesson.mybatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.mybatis.dto.ResponseTodo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//기존 DAO역할
@Mapper
public interface TodoMapper {
    //전체조회
    List<ResponseTodo> findAll();
    //하나조회
    List<ResponseTodo> findById(Long id);
    //저장
    void save(RequestTodo todo);
    //수정
    void update(RequestTodo todo);
    //삭제
    void deleteById(Long id);

    List<Member> loignchechk();

}
