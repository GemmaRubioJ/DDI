package com.example.demo.controller.database;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile(value = "mysql")
// @Component(value = "mysql")
@Component
public class MySQLConnection implements DBConnection{

	public void helloFromMySQL(){
		System.out.println("Hola desde el controlador de MySQL");
	}
	
	@Override
	public void helloFromWhateverDatabase() {
		helloFromMySQL();
	}
}
