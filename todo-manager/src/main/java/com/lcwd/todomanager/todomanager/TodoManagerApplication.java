package com.lcwd.todomanager.todomanager;

import com.lcwd.todomanager.todomanager.dao.TodoDao;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

//	@Autowired
//	private TodoDao todoDao;
	Logger logger = LoggerFactory.getLogger(TodoManagerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started");
//		logger.info("Application strated ------>>>>>");
//		JdbcTemplate temp =  todoDao.getTemplate();
//		logger.info("Template object {}",temp);
	}
}
