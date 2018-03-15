package org.maddy.java8.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExploreCompletableFuture {

	
	public static void main(String[] args) {
		 int processors = Runtime.getRuntime().availableProcessors();
		    System.out.println("CPU cores: " + processors);
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		SimulateDao simulateDao = new SimulateDao();
		List<CompletableFuture< String>> finalThreadWrapperList = new ArrayList<CompletableFuture< String>>();
		//lambda version
		for(int i=11;i<21;i++){	
			final int d=i;
			CompletableFuture <String> future = CompletableFuture.supplyAsync(()->
			                                          { return  simulateDao.readRow(d);},executorService).thenApply(str->str.toUpperCase());
			 
			finalThreadWrapperList.add(future);
		}


			
		for(CompletableFuture<String> futureObject : finalThreadWrapperList){
			 try {       
				 String threadRespwrapper=futureObject.get(); 
				 System.out.println("\n "+Thread.currentThread().getName()+":::"+threadRespwrapper);
			 } catch (InterruptedException | ExecutionException e) {
		       
			   System.out.println(e);  
			 }
		} 
		
		Integer age = -1;

		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
		    if(age < 0) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).exceptionally(ex -> {
		    System.out.println("Oops! We have an exception - " + ex.getMessage());
		    return "Unknown!";
		});

		try {
			System.out.println("Maturity : " + maturityFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		 if(null != executorService && ! executorService.isShutdown()) {
			   executorService.shutdown();
		   }
		
	
	}//End main	
	
	
	public static void compute(){
		
		
	}
	
	
}
