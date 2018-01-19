package amine.elkhoumissi.ecommerce.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.metier.CommandeMetier;

@Repository
@Transactional
public class PanierDaoImpl implements PanierDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CommandeMetier commandeMetier;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public CommandeMetier getCommandeMetier() {
		return commandeMetier;
	}

	public void setCommandeMetier(CommandeMetier commandeMetier) {
		this.commandeMetier = commandeMetier;
	}

	public Panier getPanierParId(String idPanier) {
		Session session = sessionFactory.openSession();
		Panier panier = (Panier) session.get(Panier.class, idPanier);
		// System.out.println(cart.getCartId() + " " + cart.getCartItem());
		System.out.println(panier.getIdPanier());
		session.close();
		return panier;

	}

	public Panier valider(String idPanier) throws IOException {
		Panier panier = getPanierParId(idPanier);
		if (panier == null || panier.getLingeCommandes().size() == 0) {
			throw new IOException(idPanier + "");
		}
		update(panier);
		return panier;
	}

	public void update(Panier panier) {

		String idPanier = panier.getIdPanier();
		double grandTotal = commandeMetier.getTotalCommande(idPanier);
		panier.setPrixTotal(grandTotal);

		Session session = sessionFactory.openSession();
		session.saveOrUpdate(panier);
		session.flush();
		session.close();
	}

}
