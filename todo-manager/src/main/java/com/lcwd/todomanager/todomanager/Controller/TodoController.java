package com.lcwd.todomanager.todomanager.Controller;

import java.util.*;
import com.lcwd.todomanager.todomanager.models.Todo;
import com.lcwd.todomanager.todomanager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    Logger logger = LoggerFactory.getLogger(TodoController.class);
    //create todo, we use postMapping
    @Autowired
    private TodoService todoService;





//CREATE CONTROLLER
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
//        String s = null;
//        System.out.println(s.length());
        System.out.println("i am in create");
    //create log files for information
    logger.info("creating todo");
        //call service for create todo
        Todo t1 = todoService.createTodoService(todo);
        return new ResponseEntity<>(t1, HttpStatus.CREATED);
    }


  //GET LIST CONTROLLER
    //Get all todos list
    @GetMapping("/get-list")
    public ResponseEntity<List<Todo>> getAllTodo(){
        List<Todo> listTodo = todoService.getAllTodoService();
        return new ResponseEntity<>(listTodo,HttpStatus.OK);
    }


//GET-SINGLE-LIST CONTROLLER
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getSingleTodo(@PathVariable int id){
        Todo todo = todoService.getSingleTodoService(id);
        return ResponseEntity.ok(todo);
    }


//UPDATE CONTROLLER

    @PostMapping("/update/{id}")
    //Update todo
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todoWithNewDetails, @PathVariable int id){
        Todo todo = todoService.updateTodoList(id,todoWithNewDetails);
        return ResponseEntity.ok(todo);
    }


//DELETE CONTTROLLRE
@DeleteMapping("/delete/{id}")
    //Delete Todo by id
    public ResponseEntity<String> deleteTodo(@PathVariable int id){
        todoService.deleteTodoService(id);
        return ResponseEntity.ok("Delete Successfullly");
    }

    @ExceptionHandler
    public String getException(Exception ex){
        return "Exception is ->>"+ex.getMessage();
    }
}

