package amine.elkhoumissi.ecommerce.dao;

import java.util.List;

import amine.elkhoumissi.ecommerce.entities.Produit;

public interface ProduitDao {

	List<Produit> getAllProduits();

	Produit getProduitParIdProduit(String idProduit);

	void deleteProduit(String idProduit);

	void ajouterProduit(Produit produit);
	
	void editProduit(Produit produit);
	
}
