package amine.elkhoumissi.ecommerce.metier;

import java.util.List;

import amine.elkhoumissi.ecommerce.entities.Utilisateur;

public interface UtilisateurMetier {

	List<Utilisateur> getAllUtilisateur();
	
	void deleteUtilisateur(String idUtilisateur);
	
	void ajouterUtilisateur(Utilisateur utilisateur);
	
	Utilisateur getUtilisateurParId(String idUtilisateur);
}
