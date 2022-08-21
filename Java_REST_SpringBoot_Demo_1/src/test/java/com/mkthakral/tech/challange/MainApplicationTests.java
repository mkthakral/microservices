package com.mkthakral.tech.challange;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mkthakral.tech.challange.controller.MyController;

@SpringBootTest
class MainApplicationTests {

	@Autowired
	private MyController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
