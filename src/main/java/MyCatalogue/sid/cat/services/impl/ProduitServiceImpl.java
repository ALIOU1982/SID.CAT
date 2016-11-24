package MyCatalogue.sid.cat.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import MyCatalogue.sid.cat.dao.IProduitRepository;
import MyCatalogue.sid.cat.entities.Produit;
import MyCatalogue.sid.cat.services.ProduitService;


@Service(value="ProduitService")
public class ProduitServiceImpl implements ProduitService {
	
	@Resource
	private IProduitRepository produitRepository;

	public String test() {
		return "Test";
	}

	public Produit saveProduit(Produit p) {
		return this.produitRepository.save(p);
	}

	public List<Produit> ProduitParClient(Long Id) {
		return this.produitRepository.listProduitparClient(Id);
	}

	public List<Produit> ProduitParPrix(Double PrixMin, Double PrixMax) {
		return this.produitRepository.listProduitparPrix(PrixMin, PrixMax);
	}

	public List<Produit> getAllProduits() {
		return this.produitRepository.findAll();
	}

	public Page<Produit> getAllProduits(int page) {
		return this.produitRepository.findAll(new PageRequest(page, 5));
	}

	public Page<Produit> getAllProduitsMC(String mc, int page) {
	    return this.produitRepository.produitParMC("%"+mc+"%", new PageRequest(page, 5));
	}

	public Produit getProduit(Long id) {
		return this.produitRepository.findOne(id);
	}

	public boolean deleteProduit(Long id) {
		this.produitRepository.delete(id);
		return true;
	}

	public Produit updateProduit(Produit p) {
		return this.produitRepository.saveAndFlush(p);
	}

	public IProduitRepository getProduitRepository() {
		return produitRepository;
	}

	public void setProduitRepository(IProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
	}	

}
