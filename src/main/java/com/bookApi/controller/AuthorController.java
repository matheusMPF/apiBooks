package com.bookApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookApi.entity.Author;
import com.bookApi.service.AuthorService;

@RestController
@RequestMapping("/Author")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@PostMapping("/registerAuthor")
	public void registerAuthor(@RequestBody Author author) {
		authorService.registerAuthor(author);
	}
	
	@GetMapping("/listAllAuthors")
	public List<Author> listAllAuthors(){
		return authorService.listAuthors();
	}
	
	@GetMapping("/listAuthorCpf/{cpf}")
	public Author listAuthorId(@PathVariable String cpf) {
		return authorService.listAuthorId(cpf);
	}

	
}
