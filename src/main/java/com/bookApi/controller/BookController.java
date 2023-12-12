package com.bookApi.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookApi.entity.Book;
import com.bookApi.service.BookService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	private static final String UPLOAD_DIR = "src/main/webapp/imagens/";

	
	@PostMapping(path = "/registerBook", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Book> salvar (@RequestParam("foto") MultipartFile foto,
            @RequestPart(value="book") Book book){
		
		if (foto.isEmpty()) 
            return null;
        try {
            // Obtenha o caminho completo para o diretório de destino
            String fullPath = UPLOAD_DIR + foto.getOriginalFilename();
            Path destinationPath = Paths.get(fullPath);

            // Salve o arquivo no diretório de destino
            Files.write(destinationPath, foto.getBytes());
            book.setImage("/imagens/"+foto.getOriginalFilename());

            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.registerBook(book));
        }catch (Exception e) {
			// TODO: handle exception
		}
        return null;
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
