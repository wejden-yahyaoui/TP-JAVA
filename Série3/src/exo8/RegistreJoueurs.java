package exo8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistreJoueurs {
	
	//hashMap table
	Map<Integer,List<Joueur>> map = new HashMap<Integer,List<Joueur>>();
	
	
	//addJoueur function
	public void addJoueur(Joueur Joueur) {
		if(!map.containsKey(Joueur.getDecennie(Joueur.getAnneeDeNaissance()))) {
			List<Joueur> Joueurs = new ArrayList<>();
			Joueurs.add(Joueur);
			map.put(Joueur.getDecennie(Joueur.getAnneeDeNaissance()), Joueurs);
		}
		else {
			List<Joueur> Joueurs = map.get(Joueur.getDecennie(Joueur.getAnneeDeNaissance()));
			Joueurs.add(Joueur);
			map.put(Joueur.getDecennie(Joueur.anneeDeNaissance), Joueurs);
		}
	}
	
	//get function
	public List<Joueur> get(int anneeDeNaissance){
		return (List<Joueur>) map.get(anneeDeNaissance);
	}
	
	
	//count function
	public int count (int anneeDeNaissance) {
		return ((List<Joueur>)map.get(anneeDeNaissance)).size();
	}

	
	//count () function
	public int count() {
		
		return map.values().stream().
				map(l->l.size()).
				reduce(0,(a,b)->a+b).
				intValue();
		
	}

	//toString function
	String newLine = System.getProperty("line.separator");
	@Override
	public String toString() {
		return "RegistreJoueurs" + newLine +" map="+ map +newLine + "";
	}
	
	
	
	
	
}
	
	
	

