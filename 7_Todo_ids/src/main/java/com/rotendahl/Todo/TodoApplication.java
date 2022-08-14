package com.rotendahl.Todo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TodoApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@GetMapping("/")
	public List<Todo> getTodos(@RequestParam(required = true) String id) {
		return new TodoManager(id).getTodos();
	}

	@GetMapping("/id")
	public UUID getId() {
		return UUID.randomUUID();
	}

	@PostMapping("/")
	public Todo createTodo(@RequestBody TodoInput input, @RequestParam(required = true) String id) {
		return new TodoManager(id).createTodo(input.Task, input.Due);
	}
}
