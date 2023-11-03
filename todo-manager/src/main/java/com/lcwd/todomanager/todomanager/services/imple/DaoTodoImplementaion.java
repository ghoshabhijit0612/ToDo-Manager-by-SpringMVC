package com.lcwd.todomanager.todomanager.services.imple;

import com.lcwd.todomanager.todomanager.dao.TodoDao;
import com.lcwd.todomanager.todomanager.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class DaoTodoImplementaion implements TodoServiceInterface {

    @Autowired
    private TodoDao todoDao;
    @Override
    public Todo createTodoService(Todo todo) {
        return todoDao.saveTodo(todo);
    }

    @Override
    public List<Todo> getAllTodoService() {
        return todoDao.getAllTodo();
    }

    @Override
    public Todo getSingleTodoService(int id) {
        return todoDao.getTodo(id);
    }

    @Override
    public Todo updateTodoList(int id, Todo todo) {
        return todoDao.updateTodo(id,todo);
    }

    @Override
    public void deleteTodoService(int id) {
            todoDao.deleteFromDatabase(id);
            return;
    }
}

