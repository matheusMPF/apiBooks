package com.bookApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookApi.entity.Author;
import com.bookApi.entity.Book;
import com.bookApi.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
	
	@PutMapping("/activateInactiveAuthor/{cpf}")
    public ResponseEntity<Author> activateAuthor(@PathVariable @Valid String cpf) {
        Author activateAuthor = authorService.activateInactiveAuthor(cpf);
        if (activateAuthor != null) {
            return ResponseEntity.ok(activateAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	
}
