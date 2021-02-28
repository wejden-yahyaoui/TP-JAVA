package exo8;

public class Exo8 {

	public static void main(String[] args) {
		
		RegistreJoueurs registreJoueurs = new RegistreJoueurs();
		
		Joueur J1= new Joueur ("Steve",1980);
		Joueur J2= new Joueur ("Hugo",1986);
		Joueur J3=new Joueur ("Djibril",1992);
		Joueur J4= new Joueur ("Blaise",1987);
		Joueur J5=new Joueur("Paul",1993);
		
		//test addJoueur function
		registreJoueurs.addJoueur(J1);
		registreJoueurs.addJoueur(J2);
		registreJoueurs.addJoueur(J3);
		registreJoueurs.addJoueur(J4);
		registreJoueurs.addJoueur(J5);
		
		
		System.out.println(registreJoueurs);
		
		//test count and get functions
		System.out.println("Nombre de joueurs en 1990 : " + registreJoueurs.count(1990));
		System.out.println("Liste de joueurs en 1990" + registreJoueurs.get(1990));
		System.out.println("Liste de joueurs en 1980 : " + registreJoueurs.count(1980));
		System.out.println("Liste de joueurs en 1980" + registreJoueurs.get(1980));
		
		//test count() function
		System.out.println("Nombre total de Joueurs : " + registreJoueurs.count());
		

	}

}
