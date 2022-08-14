package com.rotendahl.Todo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TodoApplication {
	private TodoManager todoManager = new TodoManager();

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@GetMapping("/")
	public List<Todo> getTodos() {
		return todoManager.getTodos();
	}

	@PostMapping("/")
	public Todo createTodo(@RequestBody TodoInput input) {
		var newTodo = todoManager.createTodo(input.Task, input.Due);
		return newTodo;
	}
}
