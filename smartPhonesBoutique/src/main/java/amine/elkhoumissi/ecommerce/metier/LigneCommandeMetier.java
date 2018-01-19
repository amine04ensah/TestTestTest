package amine.elkhoumissi.ecommerce.metier;

import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.entities.LingeCommande;

public interface LigneCommandeMetier {

	void ajouterLigneCommande(LingeCommande lingeCommande);
	void deleteLigneCommande(String idLigneCommande);
	void deleteAllLigneCommande(Panier panier);
}
