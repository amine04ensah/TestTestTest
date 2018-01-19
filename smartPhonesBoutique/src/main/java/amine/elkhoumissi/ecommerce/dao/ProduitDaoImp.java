package amine.elkhoumissi.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amine.elkhoumissi.ecommerce.entities.Produit;

@Repository
@Transactional
public class ProduitDaoImp implements ProduitDao {

	

	@Autowired
	private SessionFactory sessionFactory;

	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Produit> getAllProduits() {
		
		Session session = sessionFactory.openSession();
		
		List<Produit> produits = session.createCriteria(Produit.class).list();
		System.out.println("----- Liste des produits-----");
		
		for(Produit p:produits)
			System.out.println(p.getNomProduit());
		
		session.flush();
		session.close();
		return produits;
	}

	public Produit getProduitParIdProduit(String idProduit) {

		
		Session session = sessionFactory.openSession();
		
		Produit produit = (Produit) session.get(Produit.class, idProduit);
		session.close();
		return produit;
	}

	public void deleteProduit(String idProduit) {
		Session session = sessionFactory.openSession();
		Produit produit = (Produit) session.get(Produit.class, idProduit);
		session.delete(produit);
		session.flush();
		session.close();
	}

	public void ajouterProduit(Produit produit) {
		Session session = sessionFactory.openSession();
		session.save(produit);
		session.close();
	}

	public void editProduit(Produit produit) {
		Session session = sessionFactory.openSession();
		session.update(produit);
		session.flush();
		session.close();
	}

}
