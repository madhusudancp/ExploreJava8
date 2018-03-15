package org.maddy.java8.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExploreExecutors {

	
	public static void main(String[] args) {
	ExecutorService executorService = Executors.newFixedThreadPool(10);
	SimulateDao simulateDao = new SimulateDao();
	List<Future< String>> finalThreadWrapperList = new ArrayList<Future< String>>();
	
	
/*//callable version	
for(int i=1;i<11;i++){	
	final int d=i;
	Future <String> future = executorService.submit(new Callable <String>() {
		public String call() throws Exception {
			return  simulateDao.readRow(d);
		}																                            
     });
	finalThreadWrapperList.add(future);
}*/	

//lambda version
for(int i=11;i<21;i++){	
	final int d=i;
	Future <String> future = executorService.submit( ()->  {return  simulateDao.readRow(d);});
	finalThreadWrapperList.add(future);
}


	
for(Future<String> futureObject : finalThreadWrapperList){
	 try {       
		 String threadRespwrapper=futureObject.get(); 
		 System.out.println("\n "+Thread.currentThread().getName()+":::"+threadRespwrapper);
	 } catch (InterruptedException | ExecutionException e) {
       
	   System.out.println(e);  
	 }
} 	



	
	
	 if(null != executorService && ! executorService.isShutdown()) {
		   executorService.shutdown();
	   }
	
	
	
	
	}//End of main
}
