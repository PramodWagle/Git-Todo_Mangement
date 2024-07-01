package com.example.todo.service;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.exception.ResourceNotFoundException;
import com.example.todo.mapper.Mapper;
import com.example.todo.repository.TodoRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TodoImpl implements TodoService {
    private final TodoRepo todoRepo;

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = Mapper.mapToTodo(todoDto);
        todoRepo.save(todo);
        return Mapper.mapToTodoDto(todo);
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot find id " + id));
        return Mapper.mapToTodoDto(todo);

    }

    @Override
    public List<TodoDto> getAllTodo() {
       List<Todo> todo =  todoRepo.findAll();
      return todo.stream().map((todo1) -> Mapper.mapToTodoDto(todo1)).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
      Todo todo =   todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cannot find id " + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todo.isCompleted());
        todoRepo.save(todo);
      return   Mapper.mapToTodoDto(todo);
    }

    @Override
    public void deleteTodo(Long id) {
       todoRepo.deleteById(id);

    }

    @Override
    public TodoDto completeTodo(Long id) {
       Todo todo = todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cannot find id " + id));
     todo.setCompleted(Boolean.TRUE);
        todoRepo.save(todo);
   return Mapper.mapToTodoDto(todo);
    }

    @Override
    public TodoDto incompleteTodo(Long id) {
       Todo todo = todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cannot find id " +id));
        todo.setCompleted(Boolean.FALSE);
            todoRepo.save(todo);
         return   Mapper.mapToTodoDto(todo);
    }
}
