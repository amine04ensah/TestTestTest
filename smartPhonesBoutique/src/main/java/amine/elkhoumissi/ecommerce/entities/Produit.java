package amine.elkhoumissi.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Produits")
public class Produit implements Serializable {

	private static final long serialVersionUID = 5186013952828648626L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idProduit;
	private String catégorieProduit;
	private String descriptionProduit;
	private String fabricantProduit;
	
	@NotEmpty(message = "Le  nom du produit est un champ obligatoire")
	private String nomProduit;
	
	@NotNull(message="Donnez un prix s'il vous plaît")
	@Min(value = 100, message = "La valeur minimale du prix doit être supérieure à 100")
	private double prixProduit;
	private String unitStock;

	@Transient
	private MultipartFile imageProduit;

	

	public String getIdProduit() {
		return idProduit;
	}

	public String getCatégorieProduit() {
		return catégorieProduit;
	}

	public String getDescriptionProduit() {
		return descriptionProduit;
	}

	public String getFabricantProduit() {
		return fabricantProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public double getPrixProduit() {
		return prixProduit;
	}

	public String getUnitStock() {
		return unitStock;
	}

	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}

	public void setCatégorieProduit(String catégorieProduit) {
		this.catégorieProduit = catégorieProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public void setFabricantProduit(String fabricantProduit) {
		this.fabricantProduit = fabricantProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}

	public void setUnitStock(String unitStock) {
		this.unitStock = unitStock;
	}

	public MultipartFile getImageProduit() {
		return imageProduit;
	}

	public void setImageProduit(MultipartFile imageProduit) {
		this.imageProduit = imageProduit;
	}

	// Constructors
	

	public Produit() {

	}

	public Produit(String idProduit, String catégorieProduit, String descriptionProduit, String fabricantProduit,
			String nomProduit, double prixProduit, String unitStock) {
		super();
		this.idProduit = idProduit;
		this.catégorieProduit = catégorieProduit;
		this.descriptionProduit = descriptionProduit;
		this.fabricantProduit = fabricantProduit;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.unitStock = unitStock;
	}

}
