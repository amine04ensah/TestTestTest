package amine.elkhoumissi.ecommerce.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Panier")
public class Panier implements Serializable {

	private static final long serialVersionUID = 8436097833452420298L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idPanier;

	@OneToOne
	@JoinColumn(name = "idClient")
	@JsonIgnore
	private Client client;

	@OneToMany(mappedBy = "panier", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<LingeCommande> lingeCommandes;

	private double prixTotal;

	public String getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(String idPanier) {
		this.idPanier = idPanier;
	}

	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	public List<LingeCommande> getLingeCommandes() {
		return lingeCommandes;
	}

	public void setLingeCommandes(List<LingeCommande> lingeCommande) {
		this.lingeCommandes = lingeCommande;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

}
