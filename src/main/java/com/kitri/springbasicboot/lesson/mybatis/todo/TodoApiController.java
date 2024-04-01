package com.kitri.springbasicboot.lesson.mybatis.todo;

import com.kitri.springbasicboot.lesson.mybatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.mybatis.dto.ResponseTodo;
import com.kitri.springbasicboot.lesson.mybatis.mappers.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    @Autowired
    TodoMapper todoMapper;
    //전체조회
    @GetMapping("")
    public ArrayList<ResponseTodo> todos() {
        return (ArrayList<ResponseTodo>) todoMapper.findAll();
    }
    @GetMapping("/{id}")
    public ArrayList<ResponseTodo> todos(@PathVariable Long id) {
        return (ArrayList<ResponseTodo>) todoMapper.findById(id);
    }
    //저장
    @PostMapping("/save")
    public void add(@RequestBody RequestTodo todo) {
        todoMapper.save(todo);
    }

    //상태변경
    @PostMapping("/update")
    public void update(@RequestBody RequestTodo todo) {
        todoMapper.update(todo);
    }
    //삭제
    @PostMapping("/delete")
    public void delete(@RequestBody RequestTodo todo) {
        todoMapper.deleteById(todo.getId());
    }

}
