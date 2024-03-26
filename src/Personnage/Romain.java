package Personnage;

public class Romain 
{
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;

	public Romain(String nom, int force) 
	{
		this.nom = nom;
		// Precondition
		assert force > 0;
		this.force = force;
	}

	public String getNom() 
	{
		return nom;
	}
	
	public int getForce()
	{
		return force;
	}

	public void parler(String texte)
	{
		System.out.println(prendreParole() + " << " + texte + " >> ");
	}

	private String prendreParole() 
	{
		return ("Le Romain " + nom + " : ");
	}

//	public void recevoirCoup(int forceCoup) 
//	{
//		assert force > 0;
//		force = force - forceCoup;
//		if(force > 0) 
//		{
//			parler("Aie");
//		} 
//		else 
//		{
//			parler("J'abandonne...");
//		}
//	}
	
	public void sEquiper(Equipement equipe)
	{
		switch (nbEquipement)
		{
		case 0:
			equipements[0] = equipe;
			nbEquipement = nbEquipement + 1;
			System.out.println("Le soldat " + nom + "s'�quipe avec un " + equipe);
			break;
			
		case 1:
			if (equipe == equipements[0])
			{
				System.out.println("Le soldat " + nom + "poss�de d�j� " + equipe + " ! ");
				break;
			}
			else
			{
				equipements[1] = equipe;
				nbEquipement = nbEquipement + 1;
				System.out.println("Le soldat" + nom + "s'�quipe avec un" + equipe);
				break;
			}
			
		case 2:
			System.out.println("Le soldat" + nom + "est d�j� bien prot�g�");
			break;
		}
	}
	
	
	public Equipement[] recevoirCoup(int forceCoup) 
	{
		Equipement[] equipementEjecte = null;
		// precondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		if (force > 0) 
		{
		 	parler("Aie");
		} 
		else 
		{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		if (force == 0) 
		{	
			parler("A�e");
		}	
		else
		{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
			// post condition la force a diminuee
			assert force < oldForce;
			return equipementEjecte;
	}
	
	
	private int calculResistanceEquipement(int forceCoup) 
	{
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0)
		{
			texte += "\n Mais heureusement, grace a mon equipement sa force est diminue de " ;
			
			for (int i = 0; i < nbEquipement ; i++) 
			{
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) 
					{
						resistanceEquipement += 8;
					} 
					else 
					{
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


	private Equipement[] ejecterEquipement() 
	{
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		String message = "L'equipement de " + nom.toString() + "s'envole sous la force du coup." ;
		System.out.println(message);
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) 
		{
			if (equipements[i] == null) 
			{
				return null;
			} 
			else 
			{
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
				return equipementEjecte;
	}
	
	
	
	public static void main (String[] args)
	{
		Romain cesar = new Romain ("Cesar", 5);
		
		cesar.prendreParole();
		cesar.parler("Je suis le gouverneur des Romains");
		
		cesar.recevoirCoup(4);
		
		Romain minus = new Romain("Minus",6);
		
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.BOUCLIER);
		cesar.sEquiper(Equipement.BOUCLIER);
		
		System.out.println(cesar.equipements[1]);
	}
}