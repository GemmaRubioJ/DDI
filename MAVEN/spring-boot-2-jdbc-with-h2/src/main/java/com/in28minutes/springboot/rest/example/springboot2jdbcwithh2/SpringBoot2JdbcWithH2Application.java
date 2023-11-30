package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.controller.StudentJdbcRepository;
import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.models.student;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application  implements CommandLineRunner{
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	
    @Autowired
    StudentJdbcRepository repository;
    
    
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}
	
	@Override
    public void run(String...args) throws Exception {

        logger.info("student id 10001 -> {}", repository.findById(10001));
        
        logger.info("inserting -> {}", repository.insert(new student(10010, "john", "a1234657")));

        logger.info("update 10001 -> {}", repository.update(new student(10001, "name-updated", "new-passport")));

        repository.deleteById(10002);

        logger.info("all users 2 -> {}", repository.findAll());
    }
}
