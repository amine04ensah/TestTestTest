package amine.elkhoumissi.ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import amine.elkhoumissi.ecommerce.entities.MessageClient;
import amine.elkhoumissi.ecommerce.metier.MessageClientMetier;

@Controller
public class AccueilControleur {

	@RequestMapping({ "/index", "/index1" })
	public String sayIndex() {
		return "index1";
	}

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		return new ModelAndView("bienvenue", "hello", "Bienvenue M. AMINE EL KHOUMISSI");
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null)
			model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
		if (logout != null)
			model.addAttribute("logout", "Vous vous êtes déconnecté avec succès");
		return "seConnecter";
	}

	@RequestMapping("/aboutus")
	public String sayAbout() {
		return "proposNous";
	}

	@Autowired
	private MessageClientMetier messageClient;

	@RequestMapping(value = "/contactus")
	public ModelAndView getQuery() {
		MessageClient query = new MessageClient();
		return new ModelAndView("contactezNous", "contact", query);
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public String addQuery(@Valid @ModelAttribute(value = "contact") MessageClient query, Model model, BindingResult result) {

		if (result.hasErrors())
			return "contactezNous";

		messageClient.ajouterMessage(query);
		model.addAttribute("querySuccess",
				"Merci, votre meassage est enregitré dans notre serveur, nous allons vous appelez le plus"
				+ "rapidement possible");
		return "seConnecter";

	}
}
