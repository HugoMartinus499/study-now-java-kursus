package com.rotendahl.Todo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TodoManager {
  private List<Todo> Todos;
  private ObjectMapper _mapper;

  public TodoManager() {
    Todos = new ArrayList<>();
    _mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
  }

  public List<Todo> getTodos() {
    var new_todos = new ArrayList<Todo>();
    try {
      new_todos = _mapper.readerForListOf(Todo.class).readValue(new File("target/db.json"));
      Todos = new_todos;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new_todos;
  }

  public Todo createTodo(String task, LocalDateTime due) {
    var newTodo = new Todo(task, due);
    Todos.add(newTodo);
    try {
      _mapper.writeValue(new File("target/db.json"), Todos);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return newTodo;
  }

}
