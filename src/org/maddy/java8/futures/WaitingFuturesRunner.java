package org.maddy.java8.futures;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
* 
* @param <T> the result type
* @param <S> the task input
* 
*/
public class WaitingFuturesRunner <T,S>{

	    private final Collection<Task<T, S>> tasks;
	    private final long timeOut;
	    private final TimeUnit timeUnit;
	    private final ExecutorService executor;
	    /**
	     * Constructor, used to initialise with the required tasks
	     *
	     * @param tasks the list of tasks to execute
	     * @param timeOut  max length of time to wait
	     * @param timeUnit     time out timeUnit
	     */
	    public WaitingFuturesRunner(final Collection<Task<T, S>> tasks, final long timeOut, final TimeUnit timeUnit) {
	        this.tasks = tasks;
	        this.timeOut = timeOut;
	        this.timeUnit = timeUnit;
	        this.executor = Executors.newFixedThreadPool(tasks.size());
	    }

	    
	    
	    
	    
	    
}
