package com.bookApi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
	
	@Id
	protected String cpf;
	protected String name;
	@OneToOne
	protected Address address;
	protected boolean active;
	@OneToMany
	protected List<Book> books;
	
	//Simple constructor
	public Author() {
		super();
	}

	//Composite constructor
	public Author(String cpf, String name, Address address, boolean active) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.address = address;
		this.active = active;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	//Methods Getters and Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isActivate() {
		return active;
	}

	public void setActivate(boolean activate) {
		this.active = activate;
	}
	
	
}