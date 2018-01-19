package amine.elkhoumissi.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.entities.Client;
import amine.elkhoumissi.ecommerce.entities.Commande;
import amine.elkhoumissi.ecommerce.metier.PanierMetier;
import amine.elkhoumissi.ecommerce.metier.CommandeMetier;

@Controller
public class CommandeControleur {

	@Autowired
	private PanierMetier panierMetier;

	@Autowired
	private CommandeMetier commandeMetier;

	@RequestMapping("/order/{idPanier}")
	public String createOrder(@PathVariable("idPanier") String idPanier) {

		Commande commande = new Commande();

		Panier panier = panierMetier.getPanierParId(idPanier);
		
		commande.setPanier(panier);

		Client client = panier.getClient();

		commande.setClient(client);
		
		commande.setAdresseLivraison(client.getAdresseLivraison());

		commande.setAdresseFacturation(client.getAdresseFacturation());

		commandeMetier.ajouterCommande(commande);

		return "redirect:/checkout?idPanier=" + idPanier;
	}
}
