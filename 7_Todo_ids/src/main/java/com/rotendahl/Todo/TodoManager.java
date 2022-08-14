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
  private String _dbFile;
  private ObjectMapper _mapper;

  public TodoManager(String id) {
    _dbFile = "todo-" + id + ".json";
    _mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
  }

  public List<Todo> getTodos() {
    try {
      return _mapper.readerForListOf(Todo.class).readValue(new File(_dbFile));
    } catch (IOException e) {
      return new ArrayList<Todo>();
    }
  }

  public Todo createTodo(String task, LocalDateTime due) {
    var todos = getTodos();
    var newTodo = new Todo(task, due);
    todos.add(newTodo);
    try {
      _mapper.writeValue(new File(_dbFile), todos);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return newTodo;
  }

}
