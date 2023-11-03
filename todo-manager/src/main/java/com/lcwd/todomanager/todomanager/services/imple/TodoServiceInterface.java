package com.lcwd.todomanager.todomanager.services.imple;

import com.lcwd.todomanager.todomanager.models.Todo;

import java.util.List;

public interface TodoServiceInterface {
    public Todo createTodoService(Todo todo);
    public List<Todo> getAllTodoService();
    public Todo getSingleTodoService(int id);
    public Todo updateTodoList(int id, Todo todo);
//    private Todo findTodoById(int todoId);

    public void deleteTodoService(int id);


}
