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

import com.bookApi.entity.Book;
import com.bookApi.service.BookService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/registerBook")
	public void registerBook(@RequestBody @Valid Book book) {
		bookService.registerBook(book);
	}
	
	@GetMapping("/listAllBooks")
	public List<Book> listAllBooks(){
		return bookService.listBooks();
	}
	
	@GetMapping("/listBookIsbn/{isbn}")
	public Book listBookId(@PathVariable String isbn) {
		return bookService.listBookId(isbn);
	}
	
	@GetMapping("/listBooktitle/{title}")
	public List<Book> listBookTitle(@PathVariable String title){
		return bookService.listBooksTitle(title);
	}
	
    @PutMapping("/activateInactiveBook/{isbn}")
    public ResponseEntity<Book> activateBook(@PathVariable @Valid String isbn) {
        Book activateBook = bookService.activateInactiveBook(isbn);
        if (activateBook != null) {
            return ResponseEntity.ok(activateBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
