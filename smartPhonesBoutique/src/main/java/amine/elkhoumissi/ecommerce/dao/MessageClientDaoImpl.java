package amine.elkhoumissi.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amine.elkhoumissi.ecommerce.entities.MessageClient;

@Repository
@Transactional
public class MessageClientDaoImpl implements MessageClientDao  {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void ajouterMessage(MessageClient messageClient) {
		Session session = sessionFactory.openSession();
		session.save(messageClient);
		session.close();
	}

}
