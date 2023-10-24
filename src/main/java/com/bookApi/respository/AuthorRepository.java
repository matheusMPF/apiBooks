package com.bookApi.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookApi.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

	Optional<Author> findByCpf(String cpf);
}