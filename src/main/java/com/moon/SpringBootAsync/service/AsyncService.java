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
//			while (!future.isDone()) {
//				System.out.println("Task completion in progress...");
//				Thread.sleep(500);
//			}

		Future<AsyncDto> future1 = null;
		Future<AsyncDto> future2 = null;
		Future<AsyncDto> future3 = null;
		System.out.println("進入AsyncTask");
		
		try {
			future1 = asyncTask.startAsynctaskWithFuture();
			future2 = asyncTask.startAsynctaskWithFuture();
			future3 = asyncTask.startAsynctaskWithFuture();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			AsyncDto asyncDto1 = future1.get(5000, TimeUnit.MILLISECONDS);
			System.out.println(asyncDto1.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("1超時");
			if (null != future1) {
				future1.cancel(true);
			}
		}
		try {
			AsyncDto asyncDto2 = future2.get(5000, TimeUnit.MILLISECONDS);
			System.out.println(asyncDto2.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("2超時");
			if (null != future2) {
				future2.cancel(true);
			}
		}

		try {
			AsyncDto asyncDto3 = future3.get(5000, TimeUnit.MILLISECONDS);
			System.out.println(asyncDto3.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("3超時");
			if (null != future3) {
				future3.cancel(true);
			}
		}
	}

}
