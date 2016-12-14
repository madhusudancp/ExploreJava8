package org.maddy.java8;

  /**
    *Java 8
    *1.We can add non-abstract method implementations to interfaces by utilizing the default keyword. This feature is also known as Extension Methods.
    *2.Concrete classes only have to implement the abstract method 
    *3.The default method can be used out of the box. 
    * */

public class DefaultMethodsDemo {

	//Define an Interface with default method implementation
	interface Formula {
	    double calculate(int a);

	    default double sqrt(int a) {
	        return Math.sqrt(a);
	    }
	}
	
	public static void main(String[] args) {
	
		//Interface Formula is implemented as an anonymous object. 
		Formula formula = new Formula() {
		    @Override
		    public double calculate(int a) {
		        return sqrt(a * 100);
		    }
		};
		
		System.out.println(formula.calculate(100));     
		System.out.println(formula.sqrt(16)); 
	}
	
	
}
