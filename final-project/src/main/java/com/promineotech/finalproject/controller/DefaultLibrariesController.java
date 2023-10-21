package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.finalproject.entity.Libraries;
import com.promineotech.finalproject.service.LibrariesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultLibrariesController implements LibrariesController {

	@Autowired
	private LibrariesService librariesService;
	
	@Override
	public List<Libraries> retrieveAllLibraries() {
		log.debug("Controller: This operation obtains a list of all available libraries.");
		return librariesService.retrieveAllLibraries();
	}

}
