package com.bookApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookApi.entity.BookPublisher;
import com.bookApi.respository.BookPublisherRepository;


@Service
public class BookPublisherService {

		@Autowired
		BookPublisherRepository bookPublisherRepository;
		
		//Method for register a new book publisher
		public void registerBookPublisher(BookPublisher bookPublisher) {
			bookPublisherRepository.save(bookPublisher);
		}
		
		//Method for listing registered books publishers
		public List<BookPublisher> listAllBookPublisher(){
			return bookPublisherRepository.findAll();
		}
		
	}