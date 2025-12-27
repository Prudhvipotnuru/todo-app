package com.example.demo.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.todo.model.Todo;

@Repository
public interface TodoDAO extends JpaRepository<Todo, Long>{

	@Modifying
    @Transactional
    @Query("UPDATE Todo t SET t.completed = :completed WHERE t.id = :id")
    void mark(@Param("id") Long id, @Param("completed") boolean completed);

}
