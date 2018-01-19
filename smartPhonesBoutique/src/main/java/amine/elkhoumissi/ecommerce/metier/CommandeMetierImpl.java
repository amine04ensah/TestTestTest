package amine.elkhoumissi.ecommerce.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amine.elkhoumissi.ecommerce.dao.CommandeDao;
import amine.elkhoumissi.ecommerce.entities.Panier;
import amine.elkhoumissi.ecommerce.entities.LingeCommande;
import amine.elkhoumissi.ecommerce.entities.Commande;

@Service
public class CommandeMetierImpl implements CommandeMetier {

	@Autowired
	private CommandeDao commandeDao;
	
	@Autowired
	private PanierMetier panierMetier;
	
	public void ajouterCommande(Commande commande) {
		commandeDao.ajouterCommande(commande);
	}

	public double getTotalCommande(String idPanier) {
		double grandTotal=0;
		Panier panier = panierMetier.getPanierParId(idPanier);
		List<LingeCommande> lingeCommandes = panier.getLingeCommandes();
		
		for(LingeCommande item: lingeCommandes){
			grandTotal += item.getPrix()*item.getQuantité();
		}
		return grandTotal;
	}

}
