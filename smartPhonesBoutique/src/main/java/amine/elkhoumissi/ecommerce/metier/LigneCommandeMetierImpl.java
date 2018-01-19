package amine.elkhoumissi.ecommerce.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amine.elkhoumissi.ecommerce.dao.LingeCommandeDao;
import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.entities.LingeCommande;

@Service
public class LigneCommandeMetierImpl implements LigneCommandeMetier {

	@Autowired
	private LingeCommandeDao lingeCommandeDao;

	

	public LingeCommandeDao getLingeCommandeDao() {
		return lingeCommandeDao;
	}

	public void setLingeCommandeDao(LingeCommandeDao lingeCommandeDao) {
		this.lingeCommandeDao = lingeCommandeDao;
	}

	public void ajouterLigneCommande(LingeCommande lingeCommande) {
		lingeCommandeDao.ajouterLigneCommande(lingeCommande);

	}

	public void deleteLigneCommande(String CartItemId) {
		lingeCommandeDao.supprimerLigneCommande(CartItemId);
	}

	public void deleteAllLigneCommande(Panier panier) {
		lingeCommandeDao.supprimerTous(panier);
	}

}
