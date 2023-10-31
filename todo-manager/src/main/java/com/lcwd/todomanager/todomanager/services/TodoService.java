package com.lcwd.todomanager.todomanager.services;

import com.lcwd.todomanager.todomanager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import static com.sun.beans.introspect.PropertyInfo.Name.bound;

@Component
public class TodoService {


    //creating Logger
    Logger logger = LoggerFactory.getLogger(TodoService.class);
    List<Todo> list = new ArrayList<>(); //use as a fake database
    //create a method for todo


    public Todo createTodoService(Todo todo) {
        Random random = new Random();

        int id = random.nextInt(999999);
        todo.setId(id);
        list.add(todo);
        logger.info("Todos {}", this.list);
        return todo;


    }


    //get all todo list
    public List<Todo> getAllTodoService() {
        return list;


    }


    //get sungle todo from id
    public Todo getSingleTodoService(int id) {
        //find todo by id
        Todo t1 = list.stream().filter(t -> id == t.getId()).findAny().get();

//        Todo t2=new Todo();
        for (Todo t : list) {
            if (t.getId() == id) {
                return t;
            }
        }
        return t1;

    }


    //update todolist
    public Todo updateTodoList(int id, Todo todo) {

        Todo existingTodo = findTodoById(id);
        existingTodo.setContent(todo.getContent());
        existingTodo.setStatus(todo.getStatus());
        existingTodo.setTitle(todo.getTitle());

        return existingTodo;


    }

    private Todo findTodoById(int todoId) {
        for (Todo todo : list) {
            if (todo.getId() == todoId) {
                return todo;
            }
        }
        return null; // Todo not found
    }

    //delete obj from list
    public void deleteTodoService(int id) {

        for (Todo t : list) {
            if (t.getId() == id) {
                list.remove(t);
            }
        }
        return;

    }


    //ExceptiomHandler

}