package exo7;

import java.util.ArrayList;
import java.util.Collection;

public class EquipeLimitee {
	
	private Collection <Joueur> Joueurs; 
	private int nombreMax;
	
	//Constructor
	public EquipeLimitee( int nombreMax) {
		super();
		Joueurs = new ArrayList<>();
		this.nombreMax = nombreMax;
	}
	
	
	//addJoueur function
	public void addJoueur(Joueur Joueur) {
		if(this.Joueurs.size()<nombreMax) {
		Joueurs.add(Joueur);	
		}
		
	}
	
	
	//isJoueurPresent function
	public boolean isJoueurPresent(Joueur Joueur) {
		return Joueurs.contains(Joueur);
	}
	
	
	//addAllEquipe function
	public void addAllEquipe (Equipe equipe) {
		
		for (Joueur Joueur: equipe.Joueurs) {
			if (!isJoueurPresent(Joueur)&& this.Joueurs.size()<nombreMax) {
				addJoueur(Joueur);
			}
		}
		
		
	}	

}
