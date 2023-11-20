package com.bookApi.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	
	@Id
	protected String isbn;
	protected String title;
	protected float price;
	protected String edition;
	
	protected boolean highlights;
	protected boolean active;
	
	@ManyToOne
	protected Author author;
	@ManyToOne
	protected BookPublisher bookPublisher;
	@OneToMany
	protected List<Category> category;
	
	//Simple Constructor
	public Book() {
		super();
		
	}
	
	//composite constructor
	public Book(String isbn, String title, int pages, float price, String edition,
			boolean highlights, boolean active) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.edition = edition;
		this.highlights = highlights;
		this.active = active;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public boolean isHighlights() {
		return highlights;
	}

	public void setHighlights(boolean highlights) {
		this.highlights = highlights;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}