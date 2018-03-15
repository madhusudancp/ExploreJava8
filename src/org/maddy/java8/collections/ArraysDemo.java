package org.maddy.java8.collections;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* JAVA 8  
* This program will explore Arrays with JDK 8
* @author  Madhusudan CP
* @version 1.0
* @since   2016-11-21
* @Declaring Array
* type var-name[]; OR  type[] var-name;
*  
*  
*/
public class ArraysDemo {
	
	public static void main(String[] args) {
	
	//Declare and Initialize Array	
	Integer[] intArray =new  Integer[] {1,2,3,4,5,6,7,8,9,10};	
	//Convert to streams using Arrays
	Stream<Integer> intStream = Arrays.stream(intArray);
	//Print all even numbers
	intStream.filter(a->a%2==0).forEach(System.out::println);

	Integer[] intArray2 =new  Integer[] {1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10};
	//Convert to streams  using Stream i.e Internally it will call Arrays.stream
	Stream<Integer> intStream2 =Stream.of(intArray2);
	//Count occurrences and store in Map
	
		
	Map<Integer, Long> counters = intStream2
		     .collect(Collectors.groupingBy(p -> p,Collectors.counting()));
	
	counters.forEach((k,v)->System.out.println(k+" occurred "+v + " Times"));
	
	
	Stream.iterate(1, (Integer n) -> n + 1)
    .peek(n -> System.out.println("number generated: - " + n))
    //.limit(15)//limit on numbers generated
    .filter(n -> (n % 2 == 0))
    .peek(n -> System.out.println("Even number filter passed for - " + n))
    .limit(5)//limit on Even numbers generated
    .count();
	
	
	
	//2D Array
	int marks[][]={{50,60},{62,65},{72,66}};
	System.out.println(marks[0][0]);
	
	int mark[][];           // declare marks array
	mark = new int[3][5];   // allocate memory for storing 15 elements
	
	mark[0][0]=1;
	System.out.println(mark[0][0]);
	
	
	String[][] names = { {"Sam", "Smith"},
            {"Robert", "Delgro"},
            {"James", "Gosling"},
          };
	
	
	for (String[] a : names) {
	    for (String s : a) {
	        System.out.println(s);
	    }
	}
	
	
	Stream.of(names)
    .flatMap(Stream::of)
        .forEach(System.out::println);
	
	
	Arrays.stream(names)
    .map(a -> String.join(" ", a))
        .forEach(System.out::println);
	
	System.out.println(
		    Arrays.stream(names)
		        .map(a -> String.join(" ", a))
		            .collect(Collectors.joining(", "))
		);
	
	
	
	
	}
}
