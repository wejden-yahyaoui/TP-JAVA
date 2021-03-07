package exo9;

import java.util.function.Predicate;

public class MyPredicate {

	public static void main(String[] args) {

		String newLine = System.getProperty("line.separator");
		
		//Test length 
		Predicate <String> p1 = s -> s.length() > 4 ; 
		System.out.println( "Wejden's Length > 4 ? : " + p1.test("wejden"));
		System.out.println("Wej's Length > 4 ? : " + p1.test("wej")+newLine);
		
		//Test is Empty ?
		Predicate <String> p2 = s -> s.isEmpty() ; 
		System.out.println("is empty ? : " + p2.test(""));
		System.out.println("is empty ? : " + p2.test("wej")+newLine);
		
		
		//Test starts with J 
		Predicate<String> p3 = s -> s.startsWith("J");
		System.out.println("Jazz starts with J ?  : " + p3.test("Jazz"));
		System.out.println("Pizza starts with J ? : "   + p3.test("Pizza") + newLine);
		
		//Test length == 5
		Predicate <String> p4 = s -> s.length() == 5 ; 
		System.out.println( "Wejden's Length == 5 ? : " + p4.test("wejdn"));
		System.out.println("Wej's Length == 5 ? : " + p4.test("wej")+newLine);
		
		//test length == 5 && starts with J 
		Predicate <String> p5 = s -> s.length() == 5 && s.startsWith("J");
		System.out.println( "Jouer's Length == 5 and starts with J ? : " + p5.test("Jouer"));
		System.out.println("Joue's Length == 5 and starts with J ? : " + p5.test("Joue"));
		System.out.println("wejdn's Length == 5 and starts with J ? : " + p5.test("wejdn")+newLine);
		
		
		

	}

}
