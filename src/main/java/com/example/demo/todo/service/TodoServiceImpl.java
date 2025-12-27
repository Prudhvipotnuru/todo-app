package com.example.demo.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.todo.dao.TodoDAO;
import com.example.demo.todo.model.Todo;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	TodoDAO todoDAO;
	
	@Override
	public List<Todo> getAllTodos() {
		return todoDAO.findAll();
	}
	
	@Override
	public Todo save(Todo todo) {
		return todoDAO.save(todo);
	}
	
	@Override
	public void delete(Long id) {
		 todoDAO.deleteById(id);
	}
	
	@Override
	public void mark(Long id,boolean completed) {
		todoDAO.mark(id,completed);
	}

}
