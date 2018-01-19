package amine.elkhoumissi.ecommerce.metier;

import amine.elkhoumissi.ecommerce.entities.Panier;

public interface PanierMetier {

	Panier getPanierParId(String idPanier);
}
