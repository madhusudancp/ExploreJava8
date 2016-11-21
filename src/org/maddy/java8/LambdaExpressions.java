package org.maddy.java8;

/**
* Demo which shows the usage of Lambda expressions in java 8 
* 1. A lambda expression is an anonymous function. i.e, it’s a method without a declaration, i.e., access modifier, return value declaration, and name.
*      Eg. (type1 arg1, type2 arg2...) -> { body }
* 2. A Functional Interface is an interface with just one abstract method declared in it.
*      Eg. java.lang.Runnable is an example of a Functional Interface. There is only one method void run() declared in Runnable interface
* 3. Each lambda expression can be implicitly assigned to one of the interface called Functional interface.
*      Eg.  lambda expressions and their functional interface:
*     Consumer<Integer>  c = (int x) -> { System.out.println(x) };
*     BiConsumer<Integer, String> b = (Integer x, String y) -> System.out.println(x + " : " + y);
*     Predicate<String> p = (String s) -> { s == null };
*
*/
public class LambdaExpressions {

	
	
}
