package com.promineotech.finalproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineotech.finalproject.entity.Book;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultReaderBooksService implements ReaderBooksService {


	@Override
	public List<Book> retrieveAllReaderAndTheirBooks() {
		log.info("Service: This method retrieves all available readers and their books.");
		return null;
	}

}
