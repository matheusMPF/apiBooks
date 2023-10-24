package com.bookApi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookApi.entity.BookPublisher;

@Repository
public interface BookPublisherRepository  extends JpaRepository<BookPublisher, String>{

}