package org.maddy.java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/*
*Using stream, you can process data in a declarative way similar to SQL statements.
*Process data declaratively and leverage multicore architecture
*stream gets/computes elements on demand. It never stores the elements.
*INPUTSOURCE :Collections, Arrays, or I/O resources
*Aggregated operations :filter, map, limit, reduce, find, match, and so on.
*stream() : Returns a sequential stream considering collection as its source.
*parallelStream() : Returns a parallel Stream considering collection as its source. 
*/
public class ExploreStreams {
	
	public static void main(String[] args) {

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl","AA");
		
		long count = strings.stream().filter(string -> string.length()==4).count();
		System.out.println(count);
		List<String> filtered=strings.stream().filter(str-> !str.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);
		
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		
		Random random = new Random();
		random.doubles().limit(1).forEach(System.out::println);
		random.ints().limit(2).sorted().forEach(System.out::println);
		
		List<Integer> intList =Arrays.asList(2,2,3,4,5,6,7,8,9,1);
		
		List<Integer> squareList = intList.stream().map(i->i*i).collect(Collectors.toList());
		System.out.println(squareList);
		Set<Integer> squareSet = intList.stream().map(i->i*i).collect(Collectors.toSet());
        System.out.println(squareSet);
      //get count of empty string
        long count1 = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println(count1);
	
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
	
	
	}
}
