package com.example.restservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import controller.HelloController;

@SpringBootTest
public class SmokeTest {
	@Autowired
	private HelloController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
