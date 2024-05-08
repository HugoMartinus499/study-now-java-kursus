package com.Hugo.Todo;

import java.time.LocalDateTime;

public class Todo {
    public String Task;
    public Boolean Completed;
    public LocalDateTime Created;
    public LocalDateTime Due;

    public Todo(String task, LocalDateTime due){
        Task = task;
        Completed = false;
        Created = LocalDateTime.now();
        Due = due; 
    }
    public Todo(){
        
    }
}
