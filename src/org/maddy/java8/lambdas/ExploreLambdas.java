package org.maddy.java8.lambdas;

public class ExploreLambdas {

	interface MathOperation{
		int operation(int a, int b);
	}

	private int mathOperation(int a, int b,MathOperation operator){
		return operator.operation(a, b);
	}
	
	public static void main(String[] args) {
		ExploreLambdas lambda = new ExploreLambdas();
		MathOperation addition = (a,b)->a+b;
		MathOperation subtraction =(a,b)->a-b;
		MathOperation multiplication = (int a,int b)->{return a*b;};
		MathOperation division= (a,b)->a/b;
		
		System.out.println("ADDITION ::"+lambda.mathOperation(50, 10, addition));
		System.out.println("SUBTRACTION:: "+lambda.mathOperation(50, 10, subtraction));
		System.out.println("MULTIPLICATION:: "+lambda.mathOperation(50, 10, multiplication));
		System.out.println("DIVISION:: "+lambda.mathOperation(50, 10, division));

	
	 Greeting greet= (msg)->"Hello "+msg;
	 System.out.println(greet.greetWithHello("Maddy"));
	
	}//End main


  interface Greeting {
	  String greetWithHello(String message);
  }

}
