package amine.elkhoumissi.ecommerce.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amine.elkhoumissi.ecommerce.dao.ClientDao;
import amine.elkhoumissi.ecommerce.entities.Client;

@Service
public class ClientMetierImpl implements ClientMetier {
	@Autowired
	private ClientDao clientDao;


	@Transactional
	public void ajouterClient(Client client) {
		clientDao.ajouterClient(client);
	}

	public List<Client> getAllClient() {

		return clientDao.getAllClient();
	}

	public Client getClientParIdEmail(String idEmail) {
		return clientDao.getClientParIdEmail(idEmail);
	}

}
