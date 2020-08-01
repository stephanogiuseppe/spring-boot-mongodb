package com.mongocrud.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongocrud.api.documents.Client;
import com.mongocrud.api.repositories.ClientRepository;
import com.mongocrud.api.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> listAll() {
		return this.clientRepository.findAll();
	}

	@Override
	public Optional<Client> listById(String id) {
		return this.clientRepository.findById(id);
	}

	@Override
	public Client save(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public void delete(String id) {
		this.clientRepository.deleteById(id);
	}

}
