package amine.elkhoumissi.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.entities.LingeCommande;
import amine.elkhoumissi.ecommerce.entities.Client;
import amine.elkhoumissi.ecommerce.entities.Produit;
import amine.elkhoumissi.ecommerce.metier.LigneCommandeMetier;
import amine.elkhoumissi.ecommerce.metier.PanierMetier;
import amine.elkhoumissi.ecommerce.metier.ClientMetier;
import amine.elkhoumissi.ecommerce.metier.ProduitMetier;

@Controller
public class LigneCommandeControleur {

	@Autowired
	private PanierMetier panierMetier;

	@Autowired
	private LigneCommandeMetier ligneCommandeMetier;

	@Autowired
	private ClientMetier clientMetier;

	@Autowired
	private ProduitMetier produitMetier;

	
	

	

	public PanierMetier getPanierMetier() {
		return panierMetier;
	}

	public void setPanierMetier(PanierMetier panierMetier) {
		this.panierMetier = panierMetier;
	}

	public LigneCommandeMetier getLigneCommandeMetier() {
		return ligneCommandeMetier;
	}

	public void setLigneCommandeMetier(LigneCommandeMetier ligneCommandeMetier) {
		this.ligneCommandeMetier = ligneCommandeMetier;
	}

	public ClientMetier getClientMetier() {
		return clientMetier;
	}

	public void setClientMetier(ClientMetier clientMetier) {
		this.clientMetier = clientMetier;
	}

	public ProduitMetier getProduitMetier() {
		return produitMetier;
	}

	public void setProduitMetier(ProduitMetier produitMetier) {
		this.produitMetier = produitMetier;
	}

	@RequestMapping("/cart/add/{idProduit}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addCartItem(@PathVariable(value = "idProduit") String idProduit) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		Client client = clientMetier.getClientParIdEmail(emailId);
		System.out.println("Client : " + client.getUtilisateur().getIdEmail());
		Panier panier = client.getPanier();
		
		List<LingeCommande> lingeCommandes = panier.getLingeCommandes();
		Produit produit = produitMetier.getProduitParId(idProduit);
		for (int i = 0; i < lingeCommandes.size(); i++) {
			LingeCommande lingeCommande = lingeCommandes.get(i);
			if (produit.getIdProduit().equals(lingeCommande.getProduit().getIdProduit())) {
				lingeCommande.setQuantité(lingeCommande.getQuantité() + 1);
				lingeCommande.setPrix(lingeCommande.getQuantité() * lingeCommande.getProduit().getPrixProduit());
				ligneCommandeMetier.ajouterLigneCommande(lingeCommande);
				return;
			}
		}
		LingeCommande lingeCommande = new LingeCommande();
		lingeCommande.setQuantité(1);
		lingeCommande.setProduit(produit);
		lingeCommande.setPrix(produit.getPrixProduit() * 1);
		lingeCommande.setPanier(panier);
		ligneCommandeMetier.ajouterLigneCommande(lingeCommande);
	}

	@RequestMapping("/cart/removeCartItem/{idLigneCommande}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable(value = "idLigneCommande") String idLigneCommande) {
		ligneCommandeMetier.deleteLigneCommande(idLigneCommande);
	}

	@RequestMapping("/cart/removeAllItems/{idLigneCommande}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeAllCartItems(@PathVariable(value = "idPanier") String idPanier) {
		Panier panier = panierMetier.getPanierParId(idPanier);
		ligneCommandeMetier.deleteAllLigneCommande(panier);
	}

}
