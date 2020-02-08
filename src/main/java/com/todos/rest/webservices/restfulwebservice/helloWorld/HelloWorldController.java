package com.todos.rest.webservices.restfulwebservice.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class HelloWorldController {
	String s;
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping(path="/hello-world-bean/")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!");
	}
	
	@GetMapping(path="/hello/path-variable/{name}")
	public HelloWorldBean helloPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s!", name));
	}
}
