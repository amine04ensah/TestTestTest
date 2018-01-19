package amine.elkhoumissi.ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import amine.elkhoumissi.ecommerce.entities.AdresseFacturation;
import amine.elkhoumissi.ecommerce.entities.Client;
import amine.elkhoumissi.ecommerce.entities.AdresseLivraison;
import amine.elkhoumissi.ecommerce.entities.Utilisateur;
import amine.elkhoumissi.ecommerce.metier.ClientMetier;

@Controller
public class UtilisateurControleur {

	@Autowired
	private ClientMetier clientMetier;

	

	public ClientMetier getClientMetier() {
		return clientMetier;
	}

	public void setClientMetier(ClientMetier clientMetier) {
		this.clientMetier = clientMetier;
	}

	@RequestMapping(value = "/customer/registration")
	public ModelAndView inscriptionClient() {
		Client client = new Client();
		Utilisateur utilisateur = new Utilisateur();
		AdresseFacturation af = new AdresseFacturation();
		AdresseLivraison al = new AdresseLivraison();
		client.setAdresseLivraison(al);
		client.setAdresseFacturation(af);
		client.setUtilisateur(utilisateur);

		return new ModelAndView("inscription", "client", client);
	}

	
	@RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
	public String enregistrerClient(@Valid @ModelAttribute(value = "client") Client client, Model model,
			BindingResult result) {
		if (result.hasErrors())
			return "inscrivez-vous!";
		clientMetier.ajouterClient(client);
		model.addAttribute("InscriptionRéussite", "Inscription avec succès. Connecter-vous en utilisant le nom "
				+ "d'utilisateur et le mot de passe");
		return "seConnecter";
	}
}
