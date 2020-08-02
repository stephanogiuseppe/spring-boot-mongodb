package com.mongocrud.api.documents;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
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
	
	@NotNull(message = "Name is empty")
	private String name;
	
	@Email(message = "Invalid email")
	@NotEmpty(message = "Email is empty")
	private String email;
	
	@CPF(message = "Invalid CPF")
	@NotEmpty(message = "CPF is empty")
	private String cpf;
	
}
