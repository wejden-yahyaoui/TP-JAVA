package exo10;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyFunction {

	public static void main(String[] args) {
		
		String newLine = System.getProperty("line.separator"); 
		
		//ToUpperCase function
		Function <String , String> toUpperCase = s -> s.toUpperCase();
		System.out.println("Question 1");
		System.out.println("wejden : " + toUpperCase.apply("wejden")+ newLine);
		
		//Identity Function
		Function<String , String> word = s -> s == null ? "" : s;
		System.out.println("Question 2");
		System.out.println("wejden  : " + word.apply("wejden"));
		System.out.println("Rien : " + word.apply("") + newLine);
		
		//Length Function
		Function<String , Integer> text = s -> s.length();
		System.out.println("Question 3");
		System.out.println("wejden's Length : " + text.apply("wejden"));
		System.out.println("Rien : " + text.apply("")+newLine);
		
		
		//Function returns an opening parenthesis immediately followed by a 
		//closing parenthesis if the string passed in parameter is null
		Function<String, String> text2 = s -> s == null ? "()" : "(" + s +")"; 
		System.out.println("Question 4");
		System.out.println("wejden " + text2.apply("wejden"));
		System.out.println("Rien : " + text2.apply("")+newLine);
		
		
		//BiFunction returns the position of string 2 in string 1
		System.out.println("Question 5");
		BiFunction<String,String,Integer> position = 
				(String word1, String word2) -> word1.contains(word2) ? word1.indexOf(word2) : -1;
		System.out.println(
				"nj dans bonjour = " + position.apply("bonjour", "nj"));
		System.out.println(
				"Hello dans bonjour = " + position.apply("bonjour", "Hello")+ newLine);
		
		
		//Function returns the position of string
		System.out.println("Question 6");
		Function <String , Integer> Position  = s-> position.apply(s, "abcdefghi"); 
		System.out.println("Position = " + Position.apply("abcdefghi"));
		System.out.println("Position = " + Position.apply("hello"));
		
		

	}

}
