package exo17;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exo18.Person;

public class PersonReader {
	
		public List<Person> readFields(String fileName){
		
		File file = new File(fileName);
		List<Person> people = new ArrayList<>();
		
		try(FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);)
				{
					int numberOfPerson = dis.read();
					System.out.println(numberOfPerson);
					while(numberOfPerson>0){
						
						String lastName = dis.readUTF();
						String firstName = dis.readUTF();
						int age = dis.readInt();
						
						people.add(new Person(lastName, firstName, age));
						numberOfPerson--;
					}
				}
		
		catch (IOException e)
		
				{
					e.printStackTrace();
				}
				
		
		System.out.println(people);
		return people;
	}

}
