package org.maddy.java8;


import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerJava {
	public static void main(String[] args) {

		// I. StringJoiner

		System.out.println("### I. String Joiner");
		// -> 1. java.util.StringJoiner.StringJoiner(CharSequence delimiter)
		StringJoiner stringJoiner = new StringJoiner(",");
		stringJoiner.add("one");
		stringJoiner.add("two");
		stringJoiner.add("three");

		// Result: one,two,three
		System.out.println(stringJoiner.toString());

		// -> 2. java.util.StringJoiner.StringJoiner(CharSequence delimiter,
		// CharSequence prefix, CharSequence suffix)
		StringJoiner stringJoinerWithPrefixSufix = new StringJoiner(",", "{", "}");
		stringJoinerWithPrefixSufix.add("1");
		stringJoinerWithPrefixSufix.add("2");
		stringJoinerWithPrefixSufix.add("3");
		// Result: {1,2,3}
		System.out.println(stringJoinerWithPrefixSufix.toString());

		// II. String with static join function
		System.out.println("### II. String with static join function");
		// -> 1. String java.lang.String.join(CharSequence delimiter,
		// CharSequence... elements)
		String strWithJoiner = String.join("|", "one", "two", "three");
		// Result: one|two|three
		System.out.println(strWithJoiner);

		// -> 2. <String> List<String> java.util.Arrays.asList(String... a)
		List<String> alphabeLst = Arrays.asList("A", "B", "C");
		strWithJoiner = String.join("|", alphabeLst);
		// Result: A|B|C
		System.out.println(strWithJoiner);

		// III. Java 8 with Collectors.joining
		System.out.println("### III. Java 8 with Collectors.joining");
		// -> 1. Collector<CharSequence, ?, String>
		// java.util.stream.Collectors.joining()
		List<String> list = Arrays.asList("java6", "java7", "java8");

		String collectorJoiningResult = list.stream().map(element -> element).collect(Collectors.joining());
		// Result: java6java7java8
		System.out.println(collectorJoiningResult);

		// -> 2. Collectors.joining(CharSequence delimiter)
		collectorJoiningResult = list.stream().map(element -> element).collect(Collectors.joining(" -> "));
		// Result: java6 -> java7 -> java8
		System.out.println(collectorJoiningResult);

		// -> 3. Collectors.joining(CharSequence delimiter, CharSequence prefix,
		// CharSequence suffix)
		collectorJoiningResult = list.stream().map(element -> element).collect(Collectors.joining(" -> ", "[", "]"));
		// Result: [java6 -> java7 -> java8]
		System.out.println(collectorJoiningResult);

	}
}