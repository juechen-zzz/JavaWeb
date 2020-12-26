package com.komorebi;

import com.komorebi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class ConsumerServerApplicationTests {
	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		userService.bugTicket();
	}

}
