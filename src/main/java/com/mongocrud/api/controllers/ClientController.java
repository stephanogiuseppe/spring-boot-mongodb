package com.mongocrud.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongocrud.api.documents.Client;
import com.mongocrud.api.responses.Response;
import com.mongocrud.api.services.ClientService;

@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<Response<List<Client>>> listAll() {
		return ResponseEntity.ok(new Response<List<Client>>(this.clientService.listAll()));
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(path = "/{id")
	public ResponseEntity<Response<Client>> listById(@PathVariable(name = "id") String id) {
		return Optional.ofNullable(this.clientService.listById(id))
			.map(cliente -> ResponseEntity.ok().body(new Response<Client>(cliente.get())))
			.orElseGet((Supplier<? extends ResponseEntity<Response<Client>>>) ResponseEntity.notFound().build());
		
//		Optional<Client> client = this.clientService.listById(id);
//		if (!client.isEmpty()) {
//			return ResponseEntity.ok(new Response<Client>(client.get()));
//		}
//		
//		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Response<Client>> save(@Valid @RequestBody Client client, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Client>(errors));
		}
		return ResponseEntity.ok(new Response<Client>(this.clientService.save(client)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Client>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Client client, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Client>(errors));
		}
		client.setId(id);
		return ResponseEntity.ok(new Response<Client>(this.clientService.save(client)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.clientService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
