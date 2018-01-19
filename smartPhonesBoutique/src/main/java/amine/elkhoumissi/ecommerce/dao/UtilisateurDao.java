package amine.elkhoumissi.ecommerce.dao;

import java.util.List;

import amine.elkhoumissi.ecommerce.entities.Utilisateur;

public interface UtilisateurDao {

	List<Utilisateur> getAllUtilisateurs();

	void deleteUtilisateur(String idUtilisateur);
	
	void ajouterUtilisateur(Utilisateur utilisateur);
	
	Utilisateur getUtilisateurParId(String idUtilisateur);
}
