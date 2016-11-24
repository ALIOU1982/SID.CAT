package MyCatalogue.sid.cat.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import MyCatalogue.sid.cat.entities.Produit;
import MyCatalogue.sid.cat.services.ProduitService;


@RestController
@org.springframework.transaction.annotation.Transactional

public class CatalogueController {
	
	@Resource
	private ProduitService produitService;
	
		@RequestMapping("/test")
	public String test(){
		return this.produitService.test();
	}
	
	@RequestMapping("/save")
	public Produit saveProduit(Produit p){
		return this.produitService.saveProduit(p);
	}
	
	@RequestMapping("/ProduitParClient")
	List<Produit> ProduitParClient( @RequestParam("id") Long Id){
		return this.produitService.ProduitParClient(Id);
	}
	
	@RequestMapping("/ProduitParPrix")
	List<Produit> ProduitParPrix( @RequestParam("pmin") Double PrixMin, @RequestParam("pmax") Double PrixMax ){
		return this.produitService.ProduitParPrix(PrixMin, PrixMax);
	}
	
	@RequestMapping("/all")
	public List<Produit> getAllProduits(){
		return produitService.getAllProduits();
	}
	
	@RequestMapping("/produits")
	public Page<Produit> getAllProduits(int page){
		return this.produitService.getAllProduits(page);
	}
	
	@RequestMapping("/produitsParMC")
	public Page<Produit> getAllProduitsMC(String mc, int page){
		return this.produitService.getAllProduitsMC(mc, page);
	}
	
	@RequestMapping("/get")
	public Produit getProduit(Long id){
		return this.produitService.getProduit(id);
	}
	
	@RequestMapping("/delete")
	public boolean deleteProduit(Long id){
		this.produitService.deleteProduit(id);
		return true;
	}
	
	@RequestMapping("/update")
	public Produit updatetProduit(Produit p){
		return this.produitService.updateProduit(p);
	}

	public ProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}
}
