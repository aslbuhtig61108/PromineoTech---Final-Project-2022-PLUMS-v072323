package com.promineotech.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.finalproject.dao.ReaderDao;
import com.promineotech.finalproject.entity.Reader;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultReaderService implements ReaderService {

	@Autowired
	private ReaderDao readerDao;
	
	@Override
	public List<Reader> getAllReaders() {
		log.info("Service: This method retrieves all available readers.");
		return readerDao.getAllReaders();
	}

}
