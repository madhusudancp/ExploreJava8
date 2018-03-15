package org.maddy.java8.concurrency;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SimulateDao {

	
	public String getFiscalDetails(){
		try {
			System.out.println("\n--->getFiscalDetails Called by "+Thread.currentThread().getName());
			//SIMULATE DB call 
			TimeUnit.SECONDS.sleep(5);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MONDAY";
	}
	
	
	public Integer computeRecommendedQuantity(String msg){
		try {
			System.out.println("\n--->computeRecommendedQuantity  Called by "+Thread.currentThread().getName());
			//SIMULATE DB call 
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 100;
	}
	
	
	
	public String getResponse(){
		
		try {
			System.out.println("\n--->getResponse Called by "+Thread.currentThread().getName());
			//SIMULATE DB call 
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello";
	}
	
	
	public String insertToDb(){
		try {
			System.out.println("\n--->insertToDb Called by "+Thread.currentThread().getName());
			//SIMULATE DB call 
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	
	public  String  readRow(Integer id){
		System.out.println("\n---> Called by "+Thread.currentThread().getName()+":::At"+this.printDate(System.currentTimeMillis()));
		try {
			//DB call  simulation
			Thread.currentThread().sleep(5000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n---> Returned by "+Thread.currentThread().getName()+":::At"+this.printDate(System.currentTimeMillis()));
		return "Hello world..!:"+id;
	}
	
	
	private String printDate(long currentDateTime){
		//creating Date from millisecond
	       Date currentDate = new Date(currentDateTime);
	       //printing value of Date
	       //System.out.println("current Date: " + currentDate);
	       DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
	       //formatted value of current Date
	       //System.out.println("Milliseconds to Date: " + df.format(currentDate));
	       return df.format(currentDate);
	}
	
}
