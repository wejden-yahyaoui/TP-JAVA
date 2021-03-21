package exo17;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import exo18.Person;

public class PersonWriter {
	
	Function<Person, byte[]> personToByteArray = 
			
		p -> {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeUTF(p.getLastName());
			dos.writeUTF(p.getFirstName());
			dos.writeInt(p.getAge());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	};
	
	public void writeFields(List<Person> people,String filename)
	{
		System.out.println(people);
		
		try(FileOutputStream fos = new FileOutputStream(new File(filename),true))
		{
			System.out.println(filename);
			fos.write(people.size());
			people.stream()
					.map(personToByteArray)
					.forEach(s->
					{
						try {
							fos.write(s);
						}
						
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
		} 
		
		catch (IOException e) 
					{
						e.printStackTrace();
					}
	}

}
