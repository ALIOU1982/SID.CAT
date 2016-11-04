package MyCatalogue.sid.cat.Test;


import static org.junit.Assert.*;

import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;

import org.assertj.core.api.Assertions;
import org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MyCatalogue.sid.cat.App;
//import MyCatalogue.sid.cat.App;
import MyCatalogue.sid.cat.controllers.ClientController;
import MyCatalogue.sid.cat.dao.IClientRepository;
import MyCatalogue.sid.cat.entities.Client;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader=SpringApplicationContextLoader.class)
//@Transactional
@SpringApplicationConfiguration(classes = App.class)
public class Testmethod  {
	
	//private EntityManager em;
    @Autowired
	private ClientController clientRepository;
	
	@Autowired
	private IClientRepository clientRepo;
	
	@Test
    public void testDependencyInjection() {
      Assertions.assertThat(clientRepository).isNotNull();
      Assertions.assertThat(clientRepo).isNotNull();
}

    @Test
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
	
	/*@Test
	public void testInserClient1(){

		assertTrue(true);
		//assertEquals("Test", "Test");

	}*/

}
