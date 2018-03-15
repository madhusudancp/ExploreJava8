package org.maddy.java8.threads;
import static org.maddy.java8.threads.ThreadColors.ANSI_Yellow;

/*
*  Each thread has its own private jvm stack 
*  Stack is used to store local variables/intermediate results/track next instructions and method calls
*
*
*
*/
public class ThreadExtendsExample extends Thread{

	@Override
	public void run() {
		System.out.println(ANSI_Yellow+"Hello from Extended Thread class :"+Thread.currentThread().getName());
		
	}
}
