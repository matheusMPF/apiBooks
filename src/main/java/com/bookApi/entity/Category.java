package com.bookApi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	protected String gender;
	protected boolean OlderAge;
	@OneToMany
	protected List<Book> books;
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	//Simple Constructor
	public Category() {
		super();
	}

	public Category(Integer id, String gender, boolean olderAge) {
		super();
		this.id = id;
		this.gender = gender;
		OlderAge = olderAge;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isOlderAge() {
		return OlderAge;
	}

	public void setOlderAge(boolean olderAge) {
		OlderAge = olderAge;
	}

}

