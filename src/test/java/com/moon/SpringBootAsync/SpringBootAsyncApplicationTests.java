package com.moon.SpringBootAsync;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moon.SpringBootAsync.service.AsyncService;

@SpringBootTest
class SpringBootAsyncApplicationTests {

	@Autowired
	private AsyncService asyncService;

	@Test
	public void testAsync() {

		asyncService.doTask();
		asyncService.doTask();
		asyncService.doTask();

	}

}
