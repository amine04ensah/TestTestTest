
package amine.elkhoumissi.ecommerce.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import amine.elkhoumissi.ecommerce.entities.Produit;
import amine.elkhoumissi.ecommerce.metier.ProduitMetier;

@Controller
public class ProduitControleur {

	@Autowired
	private ProduitMetier produitMetier;

	


	public ProduitMetier getProduitMetier() {
		return produitMetier;
	}

	public void setProduitMetier(ProduitMetier produitMetier) {
		this.produitMetier = produitMetier;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10240000);
		return multipartResolver;
	}

	
	
	@RequestMapping("/getAllProducts")
	public ModelAndView getAllProducts() {
		List<Produit> produits = produitMetier.getAllProduit();
		return new ModelAndView("listeProduitsAngular", "produits", produits);
	}

	

	@RequestMapping("getProductById/{idProduit}")
	public ModelAndView getProductById(@PathVariable(value = "idProduit") String idProduit) {
		Produit produit = produitMetier.getProduitParId(idProduit);
		return new ModelAndView("pageProduit", "produit", produit);
	}

	@RequestMapping("/admin/delete/{idProduit}")
	public String deleteProduct(@PathVariable(value = "idProduit") String idProduit) {

		

		Path path = Paths.get("C:/Users/Amine/workspace/e-commerce/src/main/webapp/WEB-INF/resource/images/produits/"
				+ idProduit + ".jpg");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		produitMetier.deleteProduit(idProduit);
		
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.GET)
	public String getProductForm(Model model) {
		Produit produit = new Produit();
		
		produit.setCatégorieProduit("Android");
		model.addAttribute("produit", produit);
		return "ajouterProduit";

	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute(value = "produitForm") Produit produit, BindingResult result) {
		
		if (result.hasErrors())
			return "ajouterProduit";
		produitMetier.ajouterProduit(produit);
		MultipartFile image = produit.getImageProduit();
		if (image != null && !image.isEmpty()) {
			Path path = Paths
					.get("C:/Users/Amine/workspace/e-commerce/src/main/webapp/WEB-INF/resource/images/produits/"
							+ produit.getIdProduit() + ".jpg");

			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/editProduct/{idProduit}")
	public ModelAndView getEditForm(@PathVariable(value = "idProduit") String idProduit) {
		Produit produit = produitMetier.getProduitParId(idProduit);
		return new ModelAndView("editProduit", "produit", produit);
	}

	@RequestMapping(value = "/admin/product/editProduct", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "produit") Produit produit) {
		produitMetier.editProduit(produit);
		return "redirect:/getAllProducts";
	}

	@RequestMapping("/getProductsList")
	public @ResponseBody List<Produit> getProductsListInJson() {
		return produitMetier.getAllProduit();
	}

	@RequestMapping("/productsListAngular")
	public String getProducts() {
		return "listeProduitsAngular";
	}

}
