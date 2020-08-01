package com.mongocrud.api.services;

import java.util.List;
import java.util.Optional;

import com.mongocrud.api.documents.Client;

public interface ClientService {
	
	List<Client> listAll();

	Optional<Client> listById(String id);

	Client save(Client client);
	
	void delete(String id);

}
