package amine.elkhoumissi.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Commande")
public class Commande implements Serializable {

	private static final long serialVersionUID = -6571020025726257848L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idCommande;

	@OneToOne
	@JoinColumn(name = "idPanier")
	private Panier panier;

	@OneToOne
	@JoinColumn(name = "idClient")
	private Client client;

	@OneToOne
	@JoinColumn(name = "idAdresseLivraison")
	private AdresseLivraison adresseLivraison;

	@OneToOne
	@JoinColumn(name = "idAdresseFacturation")
	private AdresseFacturation adresseFacturation;

	

	public AdresseFacturation getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(AdresseFacturation adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public String getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}

	

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AdresseLivraison getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(AdresseLivraison adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	

}
