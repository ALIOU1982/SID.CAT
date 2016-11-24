package MyCatalogue.sid.cat.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import MyCatalogue.sid.cat.dao.IClientRepository;
import MyCatalogue.sid.cat.entities.Client;
import MyCatalogue.sid.cat.services.ClientService;

@Service(value="ClientService")
public class ClientServiceImpl implements ClientService {
	
	@Resource
	private IClientRepository clientRepository;

	public Client saveClient(Client c) {
		return this.clientRepository.save(c);
	}

	public List<Client> allClient() {
		return this.clientRepository.findAll();
	}

	public Client updateClient(Client c) {
		return this.clientRepository.saveAndFlush(c);
	}

	public Client rechercherClient(Long Id) {
		return this.clientRepository.findOne(Id);
	}

	public Client rechercheClientParPrenom(String prenom) {
		return this.clientRepository.findByPrenom(prenom);
	}

	public IClientRepository getClientRepository() {
		return clientRepository;
	}

	public void setClientRepository(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
}
