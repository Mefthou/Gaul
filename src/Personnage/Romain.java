package Personnage;


public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipement = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
	    }
	}
		
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		
		case 2:
			System.out.println("le soldat "+ nom +" est bien protege ! ");
		
		case 1:
			if(this.equipement[0]== equipement){
				System.out.println("le soldat "+ nom +" possede deja un "+ equipement +"!");
			}
			else {
				this.equipement[1]=equipement;
				System.out.println("le soldat "+ nom +" s'équipe avec un "+ equipement +" .");
				nbEquipement+=1;
			}
		
		default:
			this.equipement[0]=equipement;
			nbEquipement+=1;
		}
	
    }
	
	public static void main(String[] args) {
		Romain minus =new Romain("Minus",6);
		minus.parler("Bonjour");
		minus.recevoirCoup(5);
		minus.recevoirCoup(8);	
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}
}