package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.finalproject.entity.Reader;
import com.promineotech.finalproject.service.ReaderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j	
public class DefaultReaderController implements ReaderController {

	@Autowired
	private ReaderService readerService;
	
	// This method allows the user to retrieve a list of 
	// all existing readers including associated information
	@Override
	public List<Reader> getAllReaders() {
		log.debug("Controller: This operation obtains a list of all available readers.");		
		return readerService.getAllReaders();
	}
	
	
	
	
}
