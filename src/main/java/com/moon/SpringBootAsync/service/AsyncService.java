package com.moon.SpringBootAsync.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.SpringBootAsync.config.AsyncTask;
import com.moon.SpringBootAsync.dto.AsyncDto;

@Service
public class AsyncService {

	@Autowired
	private AsyncTask asyncTask;

	public void doTask() {

		Future<AsyncDto> future = null;
		System.out.println("進入AsyncTask");
		try {
			future = asyncTask.startAsynctaskWithFuture();
//			while (!future.isDone()) {
//				System.out.println("Task completion in progress...");
//				Thread.sleep(500);
//			}
			AsyncDto asyncDto = future.get(5000, TimeUnit.MILLISECONDS);
			System.out.println(asyncDto.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("超時");
			if (null != future) {
				future.cancel(true);
			}
		}
	}

}
