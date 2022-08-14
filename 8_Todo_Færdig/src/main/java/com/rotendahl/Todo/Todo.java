package com.rotendahl.Todo;

import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {
  public String Task;
  public Boolean Completed;
  public LocalDateTime Created;
  public LocalDateTime Due;
  public String Id;

  public Todo(String task, LocalDateTime due) {
    Task = task;
    Completed = false;
    Created = LocalDateTime.now();
    Due = due;
    Id = UUID.randomUUID().toString();
  }

  public Todo() {
  }
}
