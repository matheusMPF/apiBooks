package com.bookApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookApi.entity.Book;
import com.bookApi.respository.BookRepository;


@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	//Method for register a new book
	public Book registerBook(Book book ) {
		return bookRepository.save(book);
	}
	
	//Method for listing registered books
		public List<Book> listBooks(){
			return bookRepository.findAll();
		}
		
		//Method to listing book by isbn
		public Book listBookId(String isbn) {
			Optional<Book> bookId = bookRepository.findByIsbn(isbn);
			if(bookId.isPresent()) {
				return bookId.get();
			}else {
				return null;
			}
		}
		
		//Method to listing book by title
		public List<Book> listBooksTitle(String title){
			return bookRepository.findByTitle(title);
			
		}
		
		//Method to activate book
		public Book activateInactiveBook(String isbn) {
			Book book = bookRepository.findByIsbn(isbn).orElse(null);
			if(book != null) {
				book.setActive(!book.isActive()); //Activate
				return bookRepository.save(book);
			}
			return null;
		}
		
//		//Method to inactive book 
//		public Book inactivateBook(String isbn) {
//			Book book = bookRepository.findByIsbn(isbn).orElse(null);
//			if(book != null) {
//				book.setActive(false); //Inactive
//				return bookRepository.save(book);
//			}
//			return null;
//			
//		}

}