package com.bookApi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	
	@Id
	protected String isbn;
	protected String title;
	protected int pages;
	protected float price;
	
	@Column(length = 2500)
	protected String summary;
	protected String edition;
	protected String type;
	
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
	public Book(String isbn, String title, int pages, float price, String summary, String edition, String type,
			boolean highlights, boolean active) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.price = price;
		this.summary = summary;
		this.edition = edition;
		this.type = type;
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

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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