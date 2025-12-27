package com.example.demo.todo.service;

import java.util.List;

import com.example.demo.todo.model.Todo;

public interface TodoService {

	List<Todo> getAllTodos();

	Todo save(Todo todo);

	void delete(Long id);

	void mark(Long id, boolean completed);
}
