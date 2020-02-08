package com.todos.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class AuthenticationController {
	@GetMapping(path="/basicAuth")
	public AuthenticationBean authenticationBean() {
		return new AuthenticationBean("You are authenticated");
	}
}
