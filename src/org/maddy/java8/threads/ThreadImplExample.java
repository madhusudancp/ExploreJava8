package org.maddy.java8.threads;
import static org.maddy.java8.threads.ThreadColors.ANSI_Red;
/*
*Each thread executes a runnable object
*/
public class ThreadImplExample implements Runnable{

	@Override
	public void run() {
		System.out.println(ANSI_Red+"Hello from Runnable Implemeted  Thread :"+Thread.currentThread().getName());
		
	}

}
