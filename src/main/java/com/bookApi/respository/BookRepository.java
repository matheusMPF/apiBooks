package com.bookApi.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookApi.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

	Optional<Book> findByIsbn(String isbn);

	List<Book> findByTitle(String title);


}