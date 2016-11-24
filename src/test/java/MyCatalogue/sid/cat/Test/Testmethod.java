package MyCatalogue.sid.cat.Test;


import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;

import org.assertj.core.api.Assertions;
import org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import MyCatalogue.sid.cat.App;
import MyCatalogue.sid.cat.controllers.ClientController;
import MyCatalogue.sid.cat.dao.IClientRepository;
import MyCatalogue.sid.cat.dao.IProduitRepository;
import MyCatalogue.sid.cat.entities.Client;
import MyCatalogue.sid.cat.entities.Produit;
import junit.framework.TestCase;
import myCatalogue.sid.cat.App;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader=SpringApplicationContextLoader.class)
//@Transactional
@SpringApplicationConfiguration(classes = App.class)
public class Testmethod  {

	//private EntityManager em;
	//@Autowired
	//private ClientController clientRepository;

	@Autowired
	private IClientRepository clientRepo;

	@Autowired
	private IProduitRepository produitRepository;

	@Test
	public void testDependencyInjection() {
		Assertions.assertThat(produitRepository).isNotNull();
		Assertions.assertThat(clientRepo).isNotNull();
	}

/*	@Test
	public void testInserClient(){

		Client clt1 = new Client();
		clt1.setAdrresse("Quebec");
		clt1.setNom("BARRY");
		clt1.setPrenom("Alpha");
		assertTrue(true);
		clt1.setId(6L);
		//clientRepo.save(clt1);

		Client clt = clientRepo.findByPrenom(clt1.getPrenom());
		assertEquals(clt.getPrenom(), clt1.getPrenom());
		assertEquals(clt.getNom(), clt1.getNom());
		assertEquals(clt.getAdrresse(), clt1.getAdrresse()); 
	}
*/
	@Test
	public void testProduitPrix(){
		List<Produit> prods = produitRepository.listProduitparPrix(100.0, 2000.0);
		assertTrue(!prods.isEmpty());
	}
	
	@Test
	public void testProduitParMC(){
		Page<Produit> prodp = produitRepository.produitParMC("A", new PageRequest(0, 5));
		assertTrue(!prodp.hasNext());
	}
	
	@Test
	public void testProduitParClient(){
		List<Produit> prodp = produitRepository.listProduitparClient(1L);
		assertTrue(!prodp.isEmpty());
	}

}
