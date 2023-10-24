package com.bookApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookApi.entity.BookPublisher;
import com.bookApi.service.BookPublisherService;

@RestController
@RequestMapping("/BookPublisher")
public class BookPublisherController {
	
	@Autowired
	BookPublisherService bookPublisherService;
	
	@PostMapping("/registerBookPublisher")
	public void registerBookPublisher(BookPublisher bookPublisher) {
		bookPublisherService.registerBookPublisher(bookPublisher);
	
	}
	
	@GetMapping("/listAllBookPublisher")
	public List<BookPublisher> listAllbooksPublishers(){
		return bookPublisherService.listAllBookPublisher();
	}
}
