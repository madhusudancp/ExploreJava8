package org.maddy.java8.codingproblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramStrings {

//Two strings are anagrams if and only if their sorted strings are equal.	
	
	
	public static void main(String[] args) {
		//Initialize array
		String[] strArray = new String[]{"are","ear","tab","bat","abc","cba","ee"};
		//Convert to streams  and operate
		Map<String, Set<String>> map = Arrays.stream(strArray).collect(Collectors.groupingBy(AnagramStrings::splitAndSort, Collectors.toSet()));
		map.forEach((k,v)->{System.out.println(k+"---"+v);});
		//Collect to set and put it in a list of only anagram strings  
		List<Set<String>> anagramList= map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
		System.out.println(anagramList);
	}
	
	//java 8
	 private static String splitAndSort(String s) {
	        return Stream.of(s.split("")).sorted().collect(Collectors.joining());
	    }

	
	//java 7
	public static String getSortedString(String str){
		char[] ca = str.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca);
	}
	
	
	
}
