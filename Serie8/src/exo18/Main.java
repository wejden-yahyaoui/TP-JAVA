package exo18;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Person p1 = new Person("Yahyaoui", "Wejden", 23);
		Person p2 = new Person("Yahyaoui", "Wiem", 25);
		Person p3 = new Person("Ben cheikh", "Makerem", 24);
		
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(p1);
		listPerson.add(p2);
		listPerson.add(p3);
		
		PersonWriter pWriter = new PersonWriter();
		pWriter.writeBinaryObject(listPerson, "fileObjectPerson");
		
		PersonReader pReader = new PersonReader();
		List<Person> listPerson2 = pReader.readBinaryObject("fileObjectPerson");
		System.out.println(listPerson2);

	}

}
