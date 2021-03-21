package exo18;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
	
	public List<Person> readBinaryObject(String fileName){

		File file = new File(fileName);
		List<Person> people = new ArrayList<>();

		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);)
		{
				while(ois!=null){
					people.add((Person) ois.readObject());
				}
		}
		
		catch(EOFException e) {
			
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return people;
	}

}
