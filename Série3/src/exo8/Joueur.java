package exo8;

public class Joueur {
	
	String nom;
	int anneeDeNaissance;
	
	//Constructor
	public Joueur(String nom, int anneeDeNaissance) {
		super();
		this.nom = nom;
		this.anneeDeNaissance = anneeDeNaissance;
	}

	//Getters & Setters
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getAnneeDeNaissance() {
		return anneeDeNaissance;
	}


	public void setAnneeDeNaissance(int anneeDeNaissance) {
		this.anneeDeNaissance = anneeDeNaissance;
	}
	
	//getDecennie function
	public int getDecennie(int anneeDeNaissance) {
		int decennie=0;
		decennie= (anneeDeNaissance/10)*10;
		return decennie;
	}
	
	String newLine = System.getProperty("line.separator");
	
	//toString function
	@Override
	public String toString() {
		return " nom=" + nom + ", anneeDeNaissance=" + anneeDeNaissance + "" + newLine;
	}
	
	
	
	
	
	
	
	
	
	
	

}
