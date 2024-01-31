package com.kitri.springbasicboot.lesson.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/students") // 주소의 시작 >> localhost:8080/students
public class MappingRestController {
    static HashMap<Long, Student> students = new HashMap<>();
    static {
        students.put(1L, new Student(1L,"박준혁"));
        students.put(2L, new Student(2L,"주나영"));
        students.put(3L, new Student(3L,"김성실"));
        students.put(4L, new Student(4L,"한민선"));
    }
    @GetMapping("/student")
    public String student(){
        return  "학생";
    }
    //학생 한명 조회
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        //PathVariable를 통해 동적으로 변하는 전달받은 값을 매개변수로 사용
        return students.get(id);
    }
    //학생 전체 조회
    @GetMapping("")
    public ArrayList<Student> getAll(){
        // map -> 밸류를 arraylist로
        return new ArrayList<Student>(students.values());
    }
    //데이터를 가리키는 형식으로 사용
    //text/plain    application/json
    //즉 아래와 같은 경우, 데이터타입이 json인 것만 이 함수를 실행하겠다는 것
    @PostMapping(path = "", consumes = {"application/json"})
    public Long addStudent(){
        new Student(5L,"김미성");
        return 5L;
    }
    //아래 produce는 데이터를 생산
    @GetMapping(path = "/produces", produces = {"application/json"})
    public String produces(){
        return "OK";
    }

}
