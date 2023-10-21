package com.promineotech.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.finalproject.dao.LibrariesDao;
import com.promineotech.finalproject.entity.Libraries;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultLibrariesService implements LibrariesService {

	@Autowired
	private LibrariesDao librariesDao;
	
	@Override
	public List<Libraries> retrieveAllLibraries() {
		log.info("The retrieveAllLibraries method was called without any parameters");
		return librariesDao.retrieveAllLibraries();
	}

}
