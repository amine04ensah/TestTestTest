package amine.elkhoumissi.ecommerce.metier;

import java.util.List;

import amine.elkhoumissi.ecommerce.entities.Produit;

public interface ProduitMetier {

	public List<Produit> getAllProduit();

	public Produit getProduitParId(String idProduit);

	void deleteProduit(String idProduit);
	
	void ajouterProduit(Produit produit);
	
	void editProduit(Produit produit);
}
