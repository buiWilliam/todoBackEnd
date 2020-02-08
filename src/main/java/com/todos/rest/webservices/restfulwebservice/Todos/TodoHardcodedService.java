package com.todos.rest.webservices.restfulwebservice.Todos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	static {
		todos.add(new Todo(++idCounter,"admin","Learn Angular",new Date(),false));
		todos.add(new Todo(++idCounter,"admin","Learn SpringBoot",new Date(),false));
		
	}
	
	public List<Todo>findAll(){
		return todos;
	}
	
	public boolean deleteTodo(int id) {
			Todo todo = findById(id);
			return todos.remove(todo);
	}
	
	public Todo findById(int id) {
		for(Todo todo:todos) 
			if(todo.getId() == id)
				return todo;
		return null;
	}
	
	public Todo saveTodo(Todo todo) {
		if(todo.getId()==-1||todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteTodo(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
