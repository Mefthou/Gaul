package Personnage;

import java.util.Random;

public class Gaulois {
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	private String nom;
	private int force;
	private int effetPotion = 1;

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+ texte +">>");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + ":";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
	          + romain.getNom());
		romain.recevoirCoup((force / 3)*effetPotion);
	}
	
    public void boirePotion(int forcePotion) {
    	effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est "+forcePotion+" fois décuplée");
	}

	
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Druide panoramix = new Druide("Panoramix",5,10);
		Random random1 = new Random();
		int forcePotion = panoramix.preparerPotion(random1);
       //	System.out.println(asterix); ca n'affiche pas le nom du nouveau gaulois !!
		System.out.println(asterix.getNom());
		asterix.parler("Bonjour !");
		asterix.frapper(minus);
		asterix.boirePotion(forcePotion);
		}

}

