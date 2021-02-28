package exo7;


public class Exo7 {

	public static void main(String[] args) {
		
		Equipe equipe = new Equipe(4);
		String newLine = System.getProperty("line.separator");
		
		Joueur J1= new Joueur("Fabien",26);
		Joueur J2= new Joueur("Lilian",26);
		Joueur J3= new Joueur("Bixente",28);
		Joueur J4= new Joueur("Youri",30);
		
		//Test addJoueur function
		equipe.addJoueur(J1);
		equipe.addJoueur(J2);
		equipe.addJoueur(J3);
		equipe.addJoueur(J4);
		
		System.out.println(equipe + newLine);
		
		
		//Test isJoueurPresent function
		System.out.println("J1 existe: "+equipe.isJoueurPresent(J1));
		System.out.println("J2 existe: "+equipe.isJoueurPresent(J2));
		System.out.println("J3 existe: "+equipe.isJoueurPresent(J3));
		System.out.println("J4 existe: "+equipe.isJoueurPresent(J4) + newLine);
		
		
		//Test removeJoueur function
		equipe.removeJoueur(J4);
		equipe.removeJoueur(J3);
		System.out.println("J4 existe: "+equipe.isJoueurPresent(J4));
		System.out.println("J3 existe: "+equipe.isJoueurPresent(J3)+ newLine);
		System.out.println(equipe + newLine);
		
		//Test getNombreJoueurs function
		System.out.println("Nombre joueurs : "+equipe.getNombreJoueurs()+ newLine);
		
		//Test getMoyenneAge function
		System.out.println("Moyenne d'âge  : "+equipe.getMoyenneAge()+ newLine);
		
		
		//test addAllEquipe function
		Equipe equipe2 = new Equipe (1);
		equipe2.addJoueur(new Joueur ("Makerem", 25));
		equipe.addAllEquipe(equipe2);
		System.out.println(equipe+ newLine);
		
		//test clear function
		equipe.clear();
		System.out.println(equipe);
		
	}

}
