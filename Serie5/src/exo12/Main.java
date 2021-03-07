package exo12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class Main {

	public static void main(String[] args) {
	
		List<String> strings = Arrays.asList
				("one", "two", "three", "four", "five", "six", "seven" , "eight",
						"nine", "ten","eleven","twelve");
		
		//Display the content of words
		String newLine = System.getProperty("line.separator"); 
		System.out.println("Question1 : ");
		strings.forEach(s->System.out.println(s));
		
		//Remove words of peer length from the list
		System.out.println(newLine + "Question 2 : ");
		List<String> newList = new ArrayList<>();
		newList.addAll(strings);
		Predicate<String> Peer = (String s) -> s.length()%2 != 0;
		newList.removeIf(Peer);
		newList.forEach(s->System.out.println(s));
		
		//Capitalize each item in the list.
		System.out.println(newLine + "Question 3 : ");
		strings.forEach(s->System.out.println(s.toUpperCase()));
		
		Predicate<String> Vowels = s -> s.startsWith("a") || s.startsWith("e") ||
				s.startsWith("i") ||	s.startsWith("o") ||s.startsWith("u") ||
				s.startsWith("y");
		
		for (String s : strings) {
			System.out.println(s + " : Starts with Vowel ? " + Vowels.test(s));
		}
		
		strings.replaceAll(s -> Vowels.test(s) ? s.toUpperCase() : s);
		System.out.println(newLine +  "Capitalize only the words in the list that begin with a vowel" + newLine );
		strings.forEach(s->System.out.println(s));
		
		
		//Comparator of words based on their lengths
		System.out.println(newLine +  "Question 4");
		System.out.println("Words sorted : ");
		strings.sort(Comparator.comparing(s->s.length()));
		strings.forEach(s->System.out.println(s));
		
		//Sort the list in ascending order of word length
		//Two words of the same length will be sorted alphabetically
		
		System.out.println(newLine +  "Question 5");
		Comparator<String> cmpByLength1= Comparator.comparing(s->s.length());
	    Comparator<String> cmpByLength2= Comparator.comparing(s-> s);
	    Comparator<String> CompareByName =cmpByLength1.thenComparing(cmpByLength2);
	    strings.sort(CompareByName);
	    strings.forEach(s->System.out.println(s));
	
		
		
		

	}

}
