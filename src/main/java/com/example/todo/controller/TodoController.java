package com.example.todo.controller;


import com.example.todo.dto.TodoDto;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("create")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto) {
        TodoDto saveDtodoDto = todoService.createTodo(todoDto);
        return new ResponseEntity<>(saveDtodoDto, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getToDoWithId(@PathVariable("id") Long todoId) {

        return new ResponseEntity<>(todoService.getTodo(todoId), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<TodoDto>> getAllTodo() {
        return new ResponseEntity<>(todoService.getAllTodo(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        return new ResponseEntity<>(todoService.updateTodo(id, todoDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.completeTodo(id), HttpStatus.OK);

    }


    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDto> incompleteTodo(@PathVariable Long id) {


        return new ResponseEntity<>(todoService.incompleteTodo(id), HttpStatus.OK);


    }


}



