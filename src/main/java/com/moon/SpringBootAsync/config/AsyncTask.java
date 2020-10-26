package com.moon.SpringBootAsync.config;

import java.util.Random;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.moon.SpringBootAsync.dto.AsyncDto;

@Component
public class AsyncTask {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public Random random = new Random();

	@Async("asyncTaskExecutor")
	public void startAsynctaskWithoutFuture() throws InterruptedException {
		log.info("不返回的非同步開始");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		log.info("完成task1：" + (end - start) + "ms");
	}

	@Async("asyncTaskExecutor")
	public Future<AsyncDto> startAsynctaskWithFuture() throws InterruptedException {
		log.info("返回的非同步開始");
		long start = System.currentTimeMillis();
		AsyncDto asyncDto = new AsyncDto();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		log.info("完成task2：" + (end - start) + "ms");
		return new AsyncResult<AsyncDto>(asyncDto);
	}

}
