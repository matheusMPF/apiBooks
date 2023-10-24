package com.bookApi.entity;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class BookPublisher {
	
	@Id
	protected String isbn;
	protected String name;
	@OneToOne
	protected Address address;
	protected boolean activate;
	@OneToMany
	protected List<Book> books;
	
	//Simple constructor
	public BookPublisher() {
		super();
	}

	//Composite Constructor
	public BookPublisher(String isbn, String name, Address address, boolean activate) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.address = address;
		this.activate = activate;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

}
