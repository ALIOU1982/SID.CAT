package MyCatalogue.sid.cat.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import MyCatalogue.sid.cat.dao.IProduitRepository;
import MyCatalogue.sid.cat.entities.Produit;


@RestController
@org.springframework.transaction.annotation.Transactional
public class CatalogueController {
	
	@Autowired
	private IProduitRepository produitRepository;
	
		@RequestMapping("/test")
	public String test(){
		return "Test";
	}
	
	@RequestMapping("/save")
	public Produit saveProduit(Produit p){
		return produitRepository.save(p);
	}
	
	@RequestMapping("/ProduitParClient")
	List<Produit> ProduitParClient( @RequestParam("id") Long Id){
		return produitRepository.listProduitparClient(Id);
	}
	
	@RequestMapping("/ProduitParPrix")
	List<Produit> ProduitParPrix( @RequestParam("pmin") Double PrixMin, @RequestParam("pmax") Double PrixMax ){
		return produitRepository.listProduitparPrix(PrixMin, PrixMax);
	}
	
	@RequestMapping("/all")
	public List<Produit> getAllProduits(){
		return produitRepository.findAll();
	}
	
	@RequestMapping("/produits")
	public Page<Produit> getAllProduits(int page){
		return produitRepository.findAll(new PageRequest(page, 5));
	}
	
	@RequestMapping("/produitsParMC")
	public Page<Produit> getAllProduits(String mc, int page){
		return produitRepository.produitParMC("%"+mc+"%", new PageRequest(page, 5));
	}
	
	@RequestMapping("/get")
	public Produit getProduit(Long id){
		return produitRepository.findOne(id);
	}
	
	@RequestMapping("/delete")
	public boolean deleteProduit(Long id){
		produitRepository.delete(id);
		return true;
	}
	
	@RequestMapping("/update")
	public Produit getProduit(Produit p){
		return produitRepository.saveAndFlush(p);
	}

}
