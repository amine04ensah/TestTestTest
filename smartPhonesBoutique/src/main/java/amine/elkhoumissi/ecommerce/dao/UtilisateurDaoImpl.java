package amine.elkhoumissi.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amine.elkhoumissi.ecommerce.entities.Utilisateur;

@Repository
@Transactional
public class UtilisateurDaoImpl implements UtilisateurDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Utilisateur> getAllUtilisateurs() {
		Session session = sessionFactory.openSession();
		
	 List<Utilisateur> utilisateurs=	 session.createCriteria(Utilisateur.class).list();
	 System.out.println(utilisateurs);
		session.close();
		return utilisateurs;
	}

	public void deleteUtilisateur(String idUtilisateur) {
		Session session = sessionFactory.openSession();
		Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, idUtilisateur);
		session.saveOrUpdate(utilisateur);
		session.flush();
		session.close();
	}

	public void ajouterUtilisateur(Utilisateur utilisateur) {
		Session session = sessionFactory.openSession();
		session.save(utilisateur);
		session.close();
	}

	public Utilisateur getUtilisateurParId(String idUtilisateur) {
		
		Session session = sessionFactory.openSession();
		
		Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, idUtilisateur);
		session.close();
		return utilisateur;
	}
	
}
