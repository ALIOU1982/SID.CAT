package MyCatalogue.sid.cat.services;

import java.util.List;

import org.springframework.data.domain.Page;

import MyCatalogue.sid.cat.entities.Produit;

public interface ProduitService {
	
	String test();
	
	Produit saveProduit(Produit p);
	
	List<Produit> ProduitParClient(Long Id);
	
	List<Produit> ProduitParPrix( Double PrixMin, Double PrixMax );
	
	 List<Produit> getAllProduits();
	 
	 Page<Produit> getAllProduits(int page);
	 
	 Page<Produit> getAllProduitsMC(String mc, int page);
	 
	 Produit getProduit(Long id);
	 
	 boolean deleteProduit(Long id);
	 
	 Produit updateProduit(Produit p);

}
