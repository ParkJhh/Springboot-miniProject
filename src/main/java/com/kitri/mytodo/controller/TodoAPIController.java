package com.kitri.mytodo.controller;


import com.kitri.mytodo.dto.RequestTodo;
import com.kitri.mytodo.dto.ResponseTodo;
import com.kitri.mytodo.mappers.MytodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/mytodo")
public class TodoAPIController {
    @Autowired
    MytodoMapper mytodoMapper;
    
    //전체조회
    @GetMapping("")
    public ArrayList<ResponseTodo> todos() {
        ArrayList<ResponseTodo> x =  (ArrayList<ResponseTodo>) mytodoMapper.findAll();
        return x;
    }

    //저장
    @PostMapping("/save")
    public void add(@RequestBody RequestTodo todo) {
        mytodoMapper.save(todo);
    }
    //취소선 추가
    @PutMapping("/update")
    public void update(@RequestBody RequestTodo todo) {
        mytodoMapper.update(todo);
    }
    //삭제
    @DeleteMapping("/delete")
    public void delete(@RequestBody RequestTodo todo) {
        mytodoMapper.delete(todo.getId());
    }
}
