package com.kitri.springbasicboot.project.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    static HashMap<Integer, Todo> todos = new HashMap<>() ;
    static int id = 0;
    //전체조회
    @GetMapping("")
    public ArrayList<Todo> todos() {
        return new ArrayList<>(todos.values());
    }
    //저장
    @PostMapping("/save")
    public boolean add(@RequestBody Todo todo) {
        todo.setId(id);
        return todos.put(id++, todo) != null ? true : false;
    }
    //상태변경
    @PostMapping("/chk")
    public void chkTrue(@RequestBody Todo todo) {
        todos.get(todo.id).setChk(todo.chk);
    }
    //삭제
    @PostMapping("/delete")
    public void delete(@RequestBody Todo todo) {
        todos.remove(todo.id);
    }

}
