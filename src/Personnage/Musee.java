package Personnage;

public class Musee {
	
	// ATTRIBUTS
		private Trophee[] trophees = new Trophee[200];
		private int nbTrophee = 0;
		
		// METHODE "donnerTrophees"
		
		public void donnerTrophees (Gaulois gaulois, Equipement equipement)
		{
			if (nbTrophee < 200)
			{
				Trophee nouveauTrophee = new Trophee(gaulois, equipement);
				
				trophees[nbTrophee] = nouveauTrophee;
				nbTrophee++;
				System.out.println(gaulois.getNom() + "a placé" + equipement + "dans le musee");
			}
			else
			{
				System.out.println("Le musee est plein, on ne peut pas mettre un autre equipement");
			}
		}

}
