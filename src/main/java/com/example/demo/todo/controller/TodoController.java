package com.example.demo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.todo.model.Todo;
import com.example.demo.todo.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*") // To use Java Script
public class TodoController {
	
	@Autowired
    private TodoService todoService;
	
	// Get all todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
    
    @PostMapping("/createTodo")
    public Todo save(@RequestBody @Valid Todo todo) {
    	return todoService.save(todo);
    }
    
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
    	Long todoId = Long.parseLong(id);
    	todoService.delete(todoId);
    }
    
    @PostMapping("/mark")
    public void mark(@RequestBody @Valid Todo todo) {
    	todoService.mark(todo.getId(), todo.isCompleted());
    }

}
