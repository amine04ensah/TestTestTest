package amine.elkhoumissi.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amine.elkhoumissi.ecommerce.entities.Role;
import amine.elkhoumissi.ecommerce.entities.Client;
import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.entities.Utilisateur;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void ajouterClient (Client client) {
		
		Session session = sessionFactory.openSession();
		client.getUtilisateur().setEnabled(true);
		
		Role role = new Role();
		role.setNomRole("ROLE_USER");
		role.setIdEmail(client.getUtilisateur().getIdEmail());
		
		Panier panier = new Panier();
		client.setPanier(panier);
		
		panier.setClient(client);;
		session.save(client);
		session.save(role);
		session.flush();
		session.close();
	}

	public List<Client> getAllClient() {
		Session session = sessionFactory.openSession();
		List<Client> clients = session.createQuery("from Client").list();
		
		return clients;
	}

	public Client getClientParIdEmail(String idEmail) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Utilisateur where idEmail=?");
		query.setString(0, idEmail);
		Utilisateur utilisateur = (Utilisateur)query.uniqueResult();
		Client client = utilisateur.getClient();
		return client;
	}
	
	
}
