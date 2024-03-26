package Personnage;

import java.util.Random;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int  nbtrophees;
	private Equipement[] trophees = new Equipement[100];

	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}


	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+ texte +">>");
	}
	
	/*private String prendreParole() {
		return "Le gaulois " + nom + ":";
	}*/
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		int forceCoup = force / 3 * effetPotion;
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(forceCoup);
	}
	
	/*public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophes = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophes != null && i < trophes.length; i++,nbtrophees++) {
			this.trophees[nbtrophees] = trophes[i];
		}
	}*/

	
    public void boirePotion(int forcePotion) {
    	effetPotion += forcePotion;
		parler("Merci Druide, je sens que ma force est "+ effetPotion +" fois décuplée");
	}

	
    public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
    
 // METHODE faireUneDonnation
	
    public void faireUneDonnation(Musee musee) {
		if (nbtrophees!=0) {
			parler("Je donne au musee tous mes trophees :\n");
			for (int i=0;i<nbtrophees;i++) {
				System.out.println(trophees[i]);
			}
		}
	}
 	

	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		

       //	System.out.println(asterix); ca n'affiche pas le nom du nouveau gaulois !!
		System.out.println(asterix.getNom());
		asterix.parler("Bonjour !");
		asterix.frapper(minus);

		}

}

