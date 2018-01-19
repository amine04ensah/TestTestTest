package amine.elkhoumissi.ecommerce.dao;

import java.io.IOException;

import amine.elkhoumissi.ecommerce.entities.Panier;

public interface PanierDao {

	Panier getPanierParId(String idPanier);
	
	Panier valider(String idPanier) throws IOException;
	
	void update(Panier panier);
}
