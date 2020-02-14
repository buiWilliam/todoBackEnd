package com.todos.rest.webservices.restfulwebservice.Todos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todos.rest.webservices.restfulwebservice.Todos.Todo;
import com.todos.rest.webservices.restfulwebservice.Todos.TodoHardcodedService;

@CrossOrigin("http://localhost:4200")
@RestController
public class TodoJpaResource {
	
	@Autowired
	private TodoHardcodedService todoService;
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	@GetMapping(path="/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoJpaRepository.findByUsername(username);
	}
	
	@GetMapping(path="/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable int id){
		return todoJpaRepository.findById(id).get();
	}
	
	@PutMapping(path="/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable int id, @RequestBody Todo todo) {
		Todo todoUpdated = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
	@PostMapping(path="/jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		todo.setUsername(username);
		Todo todoNew = todoJpaRepository.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoNew.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path="/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
		todoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
