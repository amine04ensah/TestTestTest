package amine.elkhoumissi.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "LignesCommande")
public class LingeCommande implements Serializable {

	private static final long serialVersionUID = -2455760938054036364L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idLigneCommande;

	private int quantité;

	private double prix;

	@ManyToOne
	@JoinColumn(name = "idProduit")
	private Produit produit;

	@ManyToOne
	@JoinColumn(name = "idPanier")
	@JsonIgnore
	private Panier panier;

	public String getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(String idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	

	

}
