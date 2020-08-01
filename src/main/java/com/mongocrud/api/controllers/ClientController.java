package com.mongocrud.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongocrud.api.documents.Client;
import com.mongocrud.api.services.ClientService;

@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> listAll() {
		return ResponseEntity.ok(this.clientService.listAll());
	}
	
	@GetMapping(path = "/{id")
	public ResponseEntity<Optional<Client>> listById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(this.clientService.listById(id));
	}
	
	@PostMapping
	public ResponseEntity<Client> save(@RequestBody Client client) {
		return ResponseEntity.ok(this.clientService.save(client));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Client> update(@PathVariable(name = "id") String id, @RequestBody Client client) {
		client.setId(id);
		return ResponseEntity.ok(this.clientService.save(client));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> delete(@PathVariable(name = "id") String id) {
		this.clientService.delete(id);
		return ResponseEntity.ok(1);
	}
	
}
