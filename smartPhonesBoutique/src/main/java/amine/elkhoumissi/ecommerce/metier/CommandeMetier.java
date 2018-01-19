package amine.elkhoumissi.ecommerce.metier;

import amine.elkhoumissi.ecommerce.entities.Commande;

public interface CommandeMetier {

	void ajouterCommande(Commande commande);
	double getTotalCommande(String idPanier);
}
