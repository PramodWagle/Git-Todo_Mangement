package com.example.todo.service;

import com.example.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto createTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodo();

    TodoDto updateTodo(Long id , TodoDto todoDto);

    void deleteTodo(Long id);

    TodoDto completeTodo(Long id);

    TodoDto incompleteTodo(Long id);

}
