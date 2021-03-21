package exo18;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersonWriter {
	
	public void writeBinaryObject(List<Person> people,String filename)
	
	{
		try(FileOutputStream fos = new FileOutputStream(new File(filename));
				ObjectOutputStream oos = new ObjectOutputStream(fos);)
		
		{
			people.stream()
					.forEach(s->{
						try {
							oos.writeObject(s);
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
		} 
		
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}


}
