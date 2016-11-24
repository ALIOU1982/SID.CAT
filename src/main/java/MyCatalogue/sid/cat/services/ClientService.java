package MyCatalogue.sid.cat.services;

import java.util.List;

import MyCatalogue.sid.cat.entities.Client;

public interface ClientService {
	
	Client saveClient(Client c);
	
	List<Client> allClient();
	
	Client updateClient(Client c);
	
	Client rechercherClient(Long id);
	
	Client rechercheClientParPrenom(String prenom);

}
