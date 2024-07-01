package com.example.todo.mapper;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;

public class Mapper {


    public static TodoDto mapToTodoDto(Todo todo) {

        TodoDto todoDto = new TodoDto(todo.getId(),
                todo.getDescription(),
                todo.getTitle(), todo.isCompleted());

        return todoDto;
    }

    public static Todo mapToTodo(TodoDto todoDto) {
        Todo todo = new Todo(todoDto.getId(), todoDto.getTitle(),
                todoDto.getDescription(), todoDto.isCompleted());


        return todo;


    }


}
