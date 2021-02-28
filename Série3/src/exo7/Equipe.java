package exo7;

import java.util.ArrayList;
import java.util.Collection;

public class Equipe {

	public Collection <Joueur> Joueurs; 
	
	public Equipe (int i) {
	
		Joueurs = new ArrayList<>();
	}
	
	//addJoueur function
	public void addJoueur(Joueur Joueur) {
		Joueurs.add(Joueur);
	}
	
	//removeJoueur function
	public boolean removeJoueur(Joueur Joueur) {
		return Joueurs.remove(Joueur);
	}
	
	//isJoueurPresent function
	public boolean isJoueurPresent(Joueur Joueur) {
		return Joueurs.contains(Joueur);
	}
	
	//toString function
	String newLine = System.getProperty("line.separator");
	@Override
	public String toString() {
		return "Equipe : " +Joueurs.size()+ newLine +Joueurs ;
	}
	
	//addAllEquipe function
	public void addAllEquipe (Equipe equipe) {
		
		for (Joueur Joueur: equipe.Joueurs) {
			if (!isJoueurPresent(Joueur)) {
				addJoueur(Joueur);
			}
		}
		
		
	}
	
	//clear function
	public void clear() {
		this.Joueurs.clear();
	}
	
	//getNombreJoueurs function
	public int  getNombreJoueurs() {
		return this.Joueurs.size();
	}
	
	
	//getMoyenneAge function
	public double getMoyenneAge() {
		double moyenne = 0; 
		double somme = 0 ;
		for (Joueur Joueur:  this.Joueurs) {
			somme+=Joueur.getAge();			
			
		}
		moyenne=somme/this.Joueurs.size();
		return moyenne;
	}


	
	
	

}
