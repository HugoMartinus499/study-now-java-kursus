package com.rotendahl.Todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoManager {
  private List<Todo> Todos;

  public TodoManager() {
    Todos = new ArrayList<>();
  }

  public List<Todo> getTodos() {
    return Todos;
  }

  public Todo createTodo(String task, LocalDateTime due) {
    var newTodo = new Todo(task, due);
    Todos.add(newTodo);
    return newTodo;
  }

}
