package com.Hugo.Todo;

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
	private Todomanager Todomanager = new Todomanager();
	 
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@GetMapping("/")
	public List<Todo>  getTodos(){
		return Todomanager.getTodos();
	}

	@PostMapping("/")
	public Todo createTodo(@RequestBody TodoInput input){
		var NewTodo = Todomanager.createTodo(input.Task, input.Due);
		return NewTodo;
	}
}
