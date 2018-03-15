package org.maddy.java8.threads;

public class ThreadStates {

	
	public static void main(String[] args) {
		System.out.println("Main Entry :"+Thread.currentThread().getName()+":::"+Thread.currentThread().getState()+"::"+Thread.currentThread().getId()
				+"::"+Thread.currentThread().getPriority()+"::"+Thread.currentThread().getThreadGroup());
		
		Runnable r1 = ()->{System.out.println("Thread state :"+Thread.currentThread().getName()+":::"+Thread.currentThread().getState()+"::"+Thread.currentThread().getId()
			+"::"+Thread.currentThread().getPriority()+"::"+Thread.currentThread().getThreadGroup());};
		Thread t1 = new Thread(r1,"ThreadOne");
		System.out.println(t1.isAlive()+":::"+t1.getName()+":::"+t1.isDaemon()+""+t1.getState());
		t1.start(); 		
        System.out.println(t1.isAlive()+":::"+t1.getName()+":::"+t1.isDaemon());
        System.out.println("Main Exit :"+Thread.currentThread().getName()+":::"+Thread.currentThread().getState()+"::"+Thread.currentThread().getId()
				+"::"+Thread.currentThread().getPriority()+"::"+Thread.currentThread().getThreadGroup()+"::"+t1.isAlive());
	}
}
