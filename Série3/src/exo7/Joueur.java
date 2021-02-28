package exo7;

import java.util.Objects;

public class Joueur {
	
	String name;
	int age;
	
	
	//constructor
	public Joueur (String name, int age) {
		super();
		this.name=name;
		this.age=age;
	}

	//Getters & Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	//toString function
	String newLine = System.getProperty("line.separator");
	@Override
	public String toString() {
		return "Joueur  : name=" + name + ", age=" + age + "" + newLine;
	}


	//equals function
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	//compareTo function
	public int compareTo (Joueur j) {
		
		return this.name.compareTo(j.name);
	}
}
