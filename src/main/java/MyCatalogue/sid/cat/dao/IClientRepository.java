package MyCatalogue.sid.cat.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import MyCatalogue.sid.cat.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
	
	public Client findByPrenom(String prenom);
	
}
