package amine.elkhoumissi.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.entities.LingeCommande;

@Repository
@Transactional
public class LigneCommandeDaoImpl implements LingeCommandeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void ajouterLigneCommande(LingeCommande lingeCommande) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(lingeCommande);
		session.flush();
		session.close();
	}

	public void supprimerLigneCommande(String idLigneCommande) {
		Session session = sessionFactory.openSession();
		LingeCommande lingeCommande = (LingeCommande) session.get(LingeCommande.class, idLigneCommande);
		session.delete(lingeCommande);
		Panier panier = lingeCommande.getPanier();
		List<LingeCommande> lingeCommandes = panier.getLingeCommandes();
		lingeCommandes.remove(lingeCommande);
		session.flush();
		session.close();
	}

	public void supprimerTous(Panier panier) {
		List<LingeCommande> lingeCommandes = panier.getLingeCommandes();
		for (LingeCommande lingeCommande : lingeCommandes) {
			supprimerLigneCommande(lingeCommande.getIdLigneCommande());
		}
	}

}
