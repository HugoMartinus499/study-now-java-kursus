package com.rotendahl.Todo;

import java.time.LocalDateTime;
import java.util.List;

public class TodoManager {
  private List<Todo> Todos;

  public TodoManager() {
    Todos = List.of(
        new Todo("Buy milk", LocalDateTime.now().plusMinutes(90)),
        new Todo("Clean Car", LocalDateTime.now().plusDays(7)),
        new Todo("Buy a boat", LocalDateTime.now().plusYears(3)));
  }

  public List<Todo> getTodos() {
    return Todos;
  }
}
