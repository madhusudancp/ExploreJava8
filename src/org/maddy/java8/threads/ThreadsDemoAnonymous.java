package org.maddy.java8.threads;

import static org.maddy.java8.threads.ThreadColors.ANSI_Cyan;
import static org.maddy.java8.threads.ThreadColors.ANSI_Red;

public class ThreadsDemoAnonymous {

	public static void main(String[] args) {
	System.out.println("Welcome from Main Class :"+Thread.currentThread().getName());
	
	//Anonymous class
	Thread anonomousThread=	new Thread(){
			public void run(){
				System.out.println(ANSI_Red+"Hello from Thread created using Anonymous class :"+Thread.currentThread().getName());
			}
		};
	anonomousThread.setName("AnonomousClzThread");
	anonomousThread.start();
	
	
	//using Lambda 
	Thread lambdaCreatedThread =new Thread(() -> System.out.println(ANSI_Cyan+"Hello from thread created using lambda:"+Thread.currentThread().getName()));	
	lambdaCreatedThread.setName("LambdaCreatedThread"); 
	lambdaCreatedThread.start();
		
	
	
	Thread runnableanonymousSuper = new Thread(new ThreadImplExample(){
		@Override
		public void run() {
			System.out.println("Calling super class implementation");
         super.run();
			
		}
	});
	runnableanonymousSuper.start();
	
	//Lambda 
	Runnable task = () -> {
	    System.out.println("Hello from Runnable: " +Thread.currentThread().getName());
	};
	//task.run();
	Thread thread = new Thread(task,"RunnableLambdaThread");
	thread.start();


	
	System.out.println("Bye from Main Class :"+Thread.currentThread().getName());
	}
}
