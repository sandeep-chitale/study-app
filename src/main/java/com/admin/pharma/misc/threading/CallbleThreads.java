package com.admin.pharma.misc.threading;

import java.net.URL;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallbleThreads {
	public static void main(String[] args) {

		// This executes the runnable and callable tasks
			ExecutorService service = Executors.newFixedThreadPool(3);
//		ExecutorService service = Executors.newFixedThreadPool(3);

		// This holds the result of a callable task
		ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(service);

		Callable<String> c1=new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(1000);

				return "C1";
			}
		};

		Callable<String> c2=new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(500);
				return "C2";
			}
		};


//		Future<String> f1= service.submit(c1);
//		Future<String> f2= service.submit(c2);

		//Use completion service
		completionService.submit(c1);
		completionService.submit(c2);

		for(int i=0;i<3;i++){
			try {
				System.out.println(completionService.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		service.shutdownNow();
	}
}
