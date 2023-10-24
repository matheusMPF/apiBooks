package com.bookApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookApi.entity.Author;
import com.bookApi.respository.AuthorRepository;


@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	//Method for register a new author
	public void registerAuthor(Author author) {
		authorRepository.save(author);
	}
	
	//Method for listing registered authors
	public List<Author> listAuthors(){
		return authorRepository.findAll();
	}
	
	//Method to listing authors by cpf
	public Author listAuthorId(String cpf) {
		Optional<Author> authorId = authorRepository.findByCpf(cpf);
		if(authorId.isPresent()) {
			return authorId.get();
		}else {
			return null;
		}
	}

}
