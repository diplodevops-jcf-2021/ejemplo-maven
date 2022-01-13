package com.devopsusach2020;

import com.devopsusach2020.rest.RestData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class DevOpsUsach2020ApplicationTests {

	@Autowired
	private RestData controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}