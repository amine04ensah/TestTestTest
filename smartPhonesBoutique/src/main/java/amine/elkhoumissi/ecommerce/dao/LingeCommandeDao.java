package amine.elkhoumissi.ecommerce.dao;

import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.entities.LingeCommande;

public interface LingeCommandeDao {

	void ajouterLigneCommande(LingeCommande lingeCommande);
	void supprimerLigneCommande(String idLigneCommande);
	void supprimerTous(Panier panier);

}
