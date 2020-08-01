package com.mongocrud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongocrud.api.documents.Client;

public interface ClientRepository extends MongoRepository<Client, String> {}
