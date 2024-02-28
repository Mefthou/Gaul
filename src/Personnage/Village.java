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
	
	public void afficherVillageois(Chef chef) {
		System.out.println("dans le village du chef"+chef+"vivent les légendaire gaulois :");
		for(int i=0;i<nbVillageois;i++) {
			System.out.println("-"+Villageois[i].getNom());
		}
	}
	
    public static void main(String[] args) {
		Village Village = new Village("Village des Irréductible",30);
		System.out.println(Village.getNom());
//		Gaulois gaulois = Village.trouverHabitant(30);
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
//		at Personnage.Village.trouverHabitant(Village.java:23)
//		at Personnage.Village.main(Village.java:37)
		Chef chef = new Chef("Abararacourix",6,Village);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		Village.ajouterHabitant(asterix);
		Village.ajouterHabitant(obelix);
//		Gaulois gaulois = Village.trouverHabitant(1);
//		System.out.println(gaulois);
//		return null
		Village.afficherVillageois(chef);
	}
}
