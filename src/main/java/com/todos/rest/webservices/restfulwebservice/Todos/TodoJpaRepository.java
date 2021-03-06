package com.todos.rest.webservices.restfulwebservice.Todos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {
	List<Todo> findByUsername(String username);
}
