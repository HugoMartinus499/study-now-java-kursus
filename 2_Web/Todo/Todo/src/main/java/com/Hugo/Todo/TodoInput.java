package com.Hugo.Todo;

import java.time.LocalDateTime;

public class TodoInput {
    public String Task;
    public LocalDateTime Due;

    public TodoInput(String task, LocalDateTime due){
        Task = task;
        Due = due; 
    }
}
