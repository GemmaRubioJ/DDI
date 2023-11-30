package com.example.demo.controller.database;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "postgres")
// @Component(value = "postgres")
@Component
public class PostgresConnection implements DBConnection {

	public void helloFromPostgres(){
		System.out.println("Hola desde el controlador de Postgres");
	}
	
	@Override
	public void helloFromWhateverDatabase() {
		helloFromPostgres();
	}
}
