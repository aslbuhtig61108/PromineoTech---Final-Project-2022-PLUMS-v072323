package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.service.ReaderBooksService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultReaderBooksController implements ReaderBooksController {

	@Autowired
	private ReaderBooksService readerBooksService;

	@Override
	public List<Book> retrieveAllReadersAndTheirBooks() {
		log.debug("Controller: This operation lists all available reader-books records.");
		return readerBooksService.retrieveAllReaderAndTheirBooks();
	}
		
}
