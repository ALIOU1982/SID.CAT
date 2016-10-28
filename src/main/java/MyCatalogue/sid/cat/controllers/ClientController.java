package MyCatalogue.sid.cat.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import MyCatalogue.sid.cat.dao.IClientRepository;
import MyCatalogue.sid.cat.entities.Client;


@RestController
@Transactional
public class ClientController {
	
	@Autowired
	private IClientRepository clientRepository;
	
	@RequestMapping("/saveClient")
	public Client saveClient(Client c){
		return clientRepository.save(c);// .save(c);
	}
	
	@RequestMapping("/allClient")
	public List<Client> saveClient(){
		return clientRepository.findAll();// .save(c);
	}
	
	@RequestMapping("/updateClient")
	public Client getProduit(Client c){
		return clientRepository.saveAndFlush(c);
	}
	
	@RequestMapping("/RechercherClient")
	Client RechercherClient( @RequestParam("id") Long Id){
		return clientRepository.findOne(Id);
	}

}
