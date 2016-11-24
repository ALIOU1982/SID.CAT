package MyCatalogue.sid.cat.controllers;


import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import MyCatalogue.sid.cat.entities.Client;
import MyCatalogue.sid.cat.services.ClientService;


@RestController
@Transactional
public class ClientController {
	
	@Resource
	private ClientService clientService;
	
	@RequestMapping("/saveClient")
	public Client saveClient(Client c){
		return this.clientService.saveClient(c);
	}
	
	@RequestMapping("/allClient")
	public List<Client> allClient(){
		return this.clientService.allClient();
	}
	
	@RequestMapping("/updateClient")
	public Client updateClient(Client c){
		return this.clientService.updateClient(c);
	}
	
	@RequestMapping("/rechercherClient")
	public Client rechercherClient( @RequestParam("id") Long Id){
		return this.clientService.rechercherClient(Id);
	}
	
	@RequestMapping("/rechercherPrenomClient")
	public Client rechercherParPrenomClient( @RequestParam("prenom") String prenom){
		return this.clientService.rechercheClientParPrenom(prenom);
	}

}
