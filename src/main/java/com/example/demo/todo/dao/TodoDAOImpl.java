package com.example.demo.todo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class TodoDAOImpl implements TodoDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void mark(Long id,boolean completed) {
		String sql="Update todos set completed=? where id=?";
		jdbcTemplate.update(sql,completed,id);
	}
}
