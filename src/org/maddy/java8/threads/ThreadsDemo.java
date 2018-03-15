package org.maddy.java8.threads;
import static org.maddy.java8.threads.ThreadColors.*;

/* THREAD IS AN INDEPENDENT PATH OF CODE EXECUTION
 * Many threads can run concurrently in java
 * threads are used for executing asynchronous task concurrently at the same time rather than sequentially 
 * 
 * Thread is created by extending THREAD class or implementing RUNNABLE interface
 * Demon or non Demon threads 
 * Demon threads dont stop JVM from exiting after executing the program eg. GARBAGE COLLECTOR
 * Demon thread is created by SetDemon(TRUE)
 * 
 * By Default threads are non demon
 * Program exits/ends when non demon threads have been died 
 */
public class ThreadsDemo {
//Every program has a default main thread	
public static void main(String[] args) {
	
    System.out.println(ANSI_Black+"Hello from Main thread");
	Thread extendThread = new ThreadExtendsExample();
	extendThread.setName("ThreadByExtends1~");
	extendThread.start();
	
	//java.lang.IllegalThreadStateException, same thread cannot be started again
	//extendThread.start();
	Thread extendThread2 = new ThreadExtendsExample();
	extendThread2.setName("ThreadByExtends2~");
	extendThread2.start();
	
	
	
	ThreadImplExample implThread = new ThreadImplExample();
	implThread.run();
	
	
	Thread runnableThread = new Thread(new ThreadImplExample());
	runnableThread.start();
	
	
	
	System.out.println(ANSI_Black+"Hello Again from Main thread");
	
}
}
