package amine.elkhoumissi.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Clients")
public class Client implements Serializable {

	private static final long serialVersionUID = 2652327633296064143L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idClient;
	private String pr�nomClient;
	private String nomClient;
	private String t�l�pClient;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idAdresseLivraison")
	private AdresseLivraison adresseLivraison;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idAdresseFacturation")
	private AdresseFacturation adresseFacturation;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPanier")
	@JsonIgnore
	private Panier panier;

	

	public AdresseFacturation getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(AdresseFacturation adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getT�l�pClient() {
		return t�l�pClient;
	}

	public void setT�l�pClient(String t�l�pClient ) {
		this.t�l�pClient = t�l�pClient;
	}

	

	public AdresseLivraison getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(AdresseLivraison adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public String getPr�nomClient() {
		return pr�nomClient;
	}

	public void setPr�nomClient(String pr�nomClient) {
		this.pr�nomClient = pr�nomClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	

}
