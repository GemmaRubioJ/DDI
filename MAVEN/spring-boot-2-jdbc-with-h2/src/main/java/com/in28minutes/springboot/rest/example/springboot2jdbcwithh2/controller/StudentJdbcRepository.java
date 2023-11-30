package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.models.student;

@Repository
public class StudentJdbcRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class StudentRowMapper implements RowMapper<student> {
		 
	    public student mapRow(ResultSet rs, int rowNum) throws SQLException {
	        student student = new student();
	        student.setId(rs.getLong("id"));
	        student.setName(rs.getString("name"));
	        student.setPassportNumber(rs.getString("passport_number"));
	        return student;
	    }


	 }
	
	 public List<student> findAll() {
	    	return jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());
	    }
	
	
	public student findById(long id) {
		try {
	        return jdbcTemplate.queryForObject(
	            "SELECT * FROM student WHERE id = ?", 
	            new Object[] { id },
	            new BeanPropertyRowMapper<>(student.class)
	        );
	    } catch (EmptyResultDataAccessException e) {
	        // Handle the case where no Student with the provided ID is found
	        return null;
	    }
	}
	
	public int deleteById(long id) {
	    return jdbcTemplate.update("delete from student where id=?", new Object[] {
	        id
	    });
	}

	public int insert(student student) {
	    return jdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
	        new Object[] {
	            student.getId(), student.getName(), student.getPassportNumber()
	        });
	}

	public int update(student student) {
	    return jdbcTemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
	        new Object[] {
	            student.getName(), student.getPassportNumber(), student.getId()
	        });
	}
}

