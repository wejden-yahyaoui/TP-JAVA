package exo14;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

import java.util.Comparator;

public class PlayWithStream {

	public static void main(String[] args) {
		
		List<String> strings = List.of("one","two","three","four","five",
				"six","seven","eight","nine","ten","eleven","twelve");
		
		
		//Question 1
		System.out.println("Question 1");
		strings.forEach(s-> System.out.println(s));
		
		//Question 2
		System.out.println(" \nQuestion 2");
		strings.stream()
				.map(String::toUpperCase)
				.forEach(System.out::println);
		
		//Question 3
		System.out.println(" \nQuestion 3");
		strings.stream()
				.map(String::toUpperCase)
				.map(s-> s.substring(0,1))
				.forEach(System.out::println);
		
		//Question 4
		System.out.println(" \nQuestion 4");
		strings.stream()
				.map(s-> s.length())
				.forEach(System.out::println);
		
		//Question 5
		System.out.println(" \nQuestion 5");
		Long count = strings.stream().collect(counting());
		System.out.println("count = " + count);
		
		//Another method with collector	
		Long count2 =  strings.stream().count();
		System.out.println("count2 = " + count2);
		
		//Another one
		Long count3 = strings.stream().collect(Collectors.counting());
		System.out.println("count3 = " + count3);
		
		//Question 6
		System.out.println(" \nQuestion 6");
		strings.stream()
				.filter(s-> (s.length()%2 == 0))
				.forEach(System.out::println);
		
		//Question7 
		System.out.println(" \nQuestion 7");
		int long1 = strings.stream()
			.max(Comparator.comparingInt(String::length))
			.get().length();
		
		System.out.print("Length of the longest string : "+long1);
			
		//Another method
		int long2 = strings.stream()
			.mapToInt(s->s.length())
			.max()
			.getAsInt();
		
		System.out.print("\nLength of the longest string : "+long2);
		
		//Question8
		System.out.println("\n \nQuestion 8");
		strings.stream()
				.map(String::toUpperCase)
				.filter(s-> (s.length()%2 != 0))
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		//Question 9 
		System.out.println(" \nQuestion 9");
		String concatWords = 
		strings.stream()
				.filter(s-> s.length()<5)
				.sorted()
				.collect(Collectors.joining( ",","{","}"));
		System.out.println("ConcatWords = " + concatWords);
	
		//Question 10
		System.out.println(" \nQuestion 10");
		Map <Integer, List<String>> map = 
				
				strings.stream()
				.collect(
						Collectors.groupingBy(String::length)
						);
		System.out.println("\nWords by length : ");
		map.forEach((key,value)-> System.out.println(key + " = "+ value));
		
		//Question 11
		System.out.println(" \nQuestion 11");
		Map <Character, List<String>> map2 = 
				
				strings.stream()
				.collect(
						Collectors.groupingBy(word -> word.charAt(0))
						);
		
		System.out.println("\nWords by first letter : ");
		map2.forEach((key,value)-> System.out.println(key + " = "+ value));
		
		
		
	}

}
