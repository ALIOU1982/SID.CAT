package MyCatalogue.sid.cat.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import MyCatalogue.sid.cat.entities.Produit;

public interface IProduitRepository extends JpaRepository<Produit,Long>{
	
	public List<Produit> findByDesignation(String des);
	
	@Query("select p from Produit p where p.client.id = :cli")
	public List<Produit> listProduitparClient(@Param("cli")Long Id);
	
	@Query("select p from Produit p where p.prix >= :pmi and p.prix <= :pma")
	public List<Produit> listProduitparPrix(@Param("pmi")Double PrixMin, @Param("pma")Double PrixMax);
	
	public Page<Produit> findByDesignation(String des, Pageable p);	
	
	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> produitParMC(@Param("x")String mc, Pageable p);

}
