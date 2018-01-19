package amine.elkhoumissi.ecommerce.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amine.elkhoumissi.ecommerce.dao.PanierDao;
import amine.elkhoumissi.ecommerce.entities.Panier;

@Service
public class PanierMetierImpl implements PanierMetier {

	@Autowired
	private PanierDao panierDao;

	

	public PanierDao getPanierDao() {
		return panierDao;
	}



	public void setPanierDao(PanierDao panierDao) {
		this.panierDao = panierDao;
	}



	public Panier getPanierParId(String idPanier) {

		return panierDao.getPanierParId(idPanier);
	}

}
