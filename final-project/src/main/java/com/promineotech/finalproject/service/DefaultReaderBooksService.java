package com.promineotech.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.finalproject.dao.ReaderBooksDao;
import com.promineotech.finalproject.entity.ReadersBooks;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultReaderBooksService implements ReaderBooksService {

	@Autowired
	private ReaderBooksDao readerBooksDao;

	@Override
	public List <ReadersBooks> retrieveAllReadersAndTheirBooks(int readernumber_fk) {
		log.info("Service: This method retrieves all books by reader number.");
		return readerBooksDao.retrieveAllReadersAndTheirBooks(readernumber_fk);
	}

}
