package exo11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;





public class MyComparator {

	
	public static void main(String[] args) {
		
		//Compare two strings
		System.out.println("Question 1");
		String newLine = System.getProperty("line.separator"); 
		Comparator<String> cmp1 = (s1,  s2) -> s1.length() - s2.length();
		System.out.println("hello vs hi " + cmp1.compare("hello", "hi") +newLine);
		
		//Comparator that compare persons based on their last names
		System.out.println("Question 2");
		List<Person> persons = Arrays.asList(
				new Person("Wejden","Yahyaoui", 23),
				new Person("Ahmad","Bossard",  28),
				new Person("Wejden", "Bossard",  25),
				new Person("Makerem", "Ben Cheikh",  23));
		
		System.out.println("\nPersons:");
		persons.forEach(s -> System.out.println(s));

		Comparator<Person> cmpByFirstName = 
				Comparator.comparing(Person -> Person.getFirstName());
		
		persons.sort(cmpByFirstName);
		System.out.println("\nPersons sorted based on their first names:");
		persons.forEach(s -> System.out.println(s));
		
		//Another method
		
		Comparator<Person> cmpByFirstName2 = 
				Comparator.comparing(Person:: getFirstName);
		
		persons.sort(cmpByFirstName2);
		System.out.println("\nPersons sorted based on their first names with method 2:");
		persons.forEach(s -> System.out.println(s));
		
		
		
		//Comparator that compares persons based on their last and first names
		System.out.println(newLine + "Question 3");
		Comparator<Person> cmpByLastName = 
				cmpByFirstName.thenComparing(Person -> Person.getLastName());
		
		persons.sort(cmpByLastName);
		System.out.println("\nPersons sorted based on their Last names:");
		persons.forEach(s -> System.out.println(s));
		
		
		//reversed comparator
		System.out.println(newLine +  "Question 4");
		Comparator<Person> cmpByFirstNameThenLastName =
				Comparator.comparing(Person::getFirstName)
						  .thenComparing(Person::getLastName)
						  .reversed();
		
		persons.sort(cmpByFirstNameThenLastName);
		System.out.println("\nPersons sorted based on their Last names and first names reversed:");
		persons.forEach(s -> System.out.println(s));
		
		
		//A comparator of people who put null values ​​at the end of the sorting.
		System.out.println(newLine +  "Question 5");
		List<Person> persons2 = new ArrayList<>();
			Person p1 = new Person("Mahrez", "Yahyaoui", 23);
			Person p2 = new Person("NGolo", "Ben cheikh", 28);
			Person p3 = new Person("Ellen","Attia", 23);
			persons2.add(p1);
			persons2.add(null);
			persons2.add(p2);
			persons2.add(null);
			persons2.add(p3);
			persons2.add(null);
			
		System.out.println("\nPersons 2:");
		persons2.forEach(s -> System.out.println(s));
		
		persons2.sort(Comparator.nullsLast(cmpByFirstName));
		System.out.println("\nPersons 2 sorted :");
		persons2.forEach(s -> System.out.println(s));
		
		
		
	

	}

}
