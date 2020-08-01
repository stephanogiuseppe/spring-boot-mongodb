package com.mongocrud.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String cpf;

	public void setId(String id) {
		this.id = id;
	}
}
