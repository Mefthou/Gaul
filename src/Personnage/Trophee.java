package Personnage;

public class Trophee {
	
	// ATTRIBUTS
		private Gaulois gaulois;
		private Equipement equipement;
		
		// CONSTRUCTEUR
		
		public Trophee (Gaulois gaulois, Equipement equipement)
		{
			this.gaulois = gaulois;
			this.equipement = equipement;
		}
		
		// LES GUETTEURS
		
		public Gaulois getNom()
		{
			return gaulois;
		}
		
		public Equipement getEquipement()
		{
			return equipement;
		}
		
		// METHODE donnerNom
		
		public static void donnerNom(Gaulois gaulois)
		{
			 System.out.println("Le nom du Gaulois est " + gaulois.getNom());		
		}
		
		// LE MAIN POUR TESTER
		
		public static void main(String[] args)
		{
			// TEST pour le "donnerNom"
			Gaulois eliott = new Gaulois ("Eliott", 8);
			donnerNom(eliott);
		}

}
