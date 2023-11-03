package com.lcwd.todomanager.todomanager.dao;

import com.lcwd.todomanager.todomanager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TodoDao
{
    Logger logger = LoggerFactory.getLogger(TodoDao.class);



    JdbcTemplate templates;
    public TodoDao(  JdbcTemplate templates) {
        this.templates = templates;

        String createTable = "create table IF NOT EXISTS todos (id int primary key, title varchar(200), content varchar(200), status varchar(250))";
        int value = templates.update(createTable);
        logger.info("successfully created {}",value);
    }

    public JdbcTemplate getTemplate() {
        return templates;
    }

    public void setTemplate(JdbcTemplate template) {
        this.templates = template;
    }

    //savve todo in database
    public Todo saveTodo(Todo todo){
        String insertIntoDb = "insert into todos(id,title,content,status) values (?,?,?,?)";
        int rows = templates.update(insertIntoDb,todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus());
        logger.info("insetion Done with rows-> {}",rows);
        return todo;
    }


    //get single object from database
    public Todo getTodo(int id){
        String query="select * from todos where id = ?";
       Map<String,Object > todoObj =templates.queryForMap(query,id);
        Todo todo = new Todo(
                id,
                (String) todoObj.get("title"),
                (String) todoObj.get("content"),
                (String) todoObj.get("status")
        );
        return todo;





    }

    //get all todo from database
public List<Todo> getAllTodo(){
        String query = "select * from todos ";
        List<Map<String,Object>> todoGetAllData = templates.queryForList(query);
        List<Todo> ansTodo= todoGetAllData.stream().map(
                (map)->{
                    Todo todo = new Todo(
                            (int) map.get("id"),
                            (String) map.get("title"),
                            (String) map.get("content"),
                            (String) map.get("status")
                    );
                    return todo;
                }
        ).collect(Collectors.toList());
        return ansTodo;

}
    //update todo from database
public Todo updateTodo(int id , Todo todo){
//        Todo getTodoList = getTodo(id);
        String query = "update todos set title=?,content=?,status=? where id = ?";
        int rows = templates.update(query,todo.getTitle(),todo.getContent(),todo.getStatus(),id);

        logger.info("Updated value : {}",rows);
        return todo;




}


//Delete from DataBase
    public void deleteFromDatabase(int id){

        String query = "DELETE FROM todos WHERE id = ?";
        int rows = templates.update(query,id);
        return;

    }
}
