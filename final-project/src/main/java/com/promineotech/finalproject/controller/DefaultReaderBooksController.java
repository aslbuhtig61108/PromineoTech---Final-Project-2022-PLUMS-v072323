package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.finalproject.entity.ReadersBooks;
import com.promineotech.finalproject.service.ReaderBooksService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultReaderBooksController implements ReaderBooksController {

	@Autowired
	private ReaderBooksService readerBooksService;

	@Override
	public List<ReadersBooks> retrieveAllReadersAndTheirBooks(int readernumber_fk) {
		log.debug("Controller: This operation lists all available reader-books records.");
		return readerBooksService.retrieveAllReadersAndTheirBooks(readernumber_fk);
	}
		
}
