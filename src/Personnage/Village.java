package Personnage;


public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] Villageois;
	private int nbVillageois=0;

	

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		Villageois = new Gaulois[nbVillageoisMax];
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		this.Villageois[this.nbVillageois] = gaulois;
		this.nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int a) {
		return Villageois[a];	
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}


	public String getNom() {
		return nom;
	}

}
