package Personnage;


public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement=0;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>0;
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
	
	
    /*public void recevoirCoup(int forceCoup) {
     * assert force>0;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
	    }
	}*/
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		if(force==0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	public int getForce() {
		return force;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		    for (int i = 0; i < nbEquipement;i++) {
		    	if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) == true) {
		    		resistanceEquipement += 8;
		    	} else {
		    		System.out.println("Equipement casque");
		    		resistanceEquipement += 5;
		    	}
		    }
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
		
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
			}
		}
		return equipementEjecte;
	}

		
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		
		case 2:
			System.out.println("le soldat "+ nom +" est bien protege ! ");
			break;
		
		case 1:
			if(this.equipement[0]== equipement){
				System.out.println("le soldat "+ nom +" possede deja un "+ equipement +"!");
			}
			else {
				this.equipement[1]=equipement;
				System.out.println("le soldat "+ nom +" s'équipe avec un "+ equipement +" .");
				nbEquipement+=1;
				
			}
			break;
		default:
			this.equipement[0]=equipement;
			nbEquipement+=1;
		}
	
    }
	
	public static void main(String[] args) {
		Romain minus =new Romain("Minus",6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.parler("Bonjour");
		minus.recevoirCoup(5);
		minus.recevoirCoup(8);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}