package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.database.DBConnection;
import com.example.demo.controller.database.H2Connection;
import com.example.demo.model.Student;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
public class StudentController {
	
	@Autowired
	// @Qualifier(value= "postgres")
	DBConnection db;
	
	//localhost:8080/insertStudent
	@RequestMapping("/insertStudent")
	public String insertarEstudiante (Student student, Model model) {
		System.out.println("name: " + student.getNombre());
		db.helloFromWhateverDatabase();
		return "fin";
	}
}
