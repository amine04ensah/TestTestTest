package amine.elkhoumissi.ecommerce.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messagesClient")
public class MessageClient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMessageClient;

	private String email;
	private String sujet;
	private String message;

	public int getIdMessageClient() {
		return idMessageClient;
	}

	public void setIdMessageClient(int idMessageClient) {
		this.idMessageClient = idMessageClient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
