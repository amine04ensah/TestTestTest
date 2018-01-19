package amine.elkhoumissi.ecommerce.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amine.elkhoumissi.ecommerce.dao.UtilisateurDao;
import amine.elkhoumissi.ecommerce.entities.Utilisateur;

@Service
public class UtilisateurMetierImpl implements UtilisateurMetier {

	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Transactional
	public List<Utilisateur> getAllUtilisateur() {
	return utilisateurDao.getAllUtilisateurs();
	}

	@Transactional
	public void deleteUtilisateur(String idUtilisateur) {
		utilisateurDao.deleteUtilisateur(idUtilisateur);
	}
	@Transactional 
	public void ajouterUtilisateur(Utilisateur utilisateur){
		utilisateurDao.ajouterUtilisateur(utilisateur);
	}
	
	public Utilisateur getUtilisateurParId(String idUtilisateur) {
		return utilisateurDao.getUtilisateurParId(idUtilisateur);
	}

	
}
