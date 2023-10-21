package com.promineotech.finalproject.dao;

import java.util.List;

import com.promineotech.finalproject.entity.ReadersBooks;

public interface ReaderBooksDao {

	List<ReadersBooks> retrieveAllReadersAndTheirBooks(int readernumber_fk);


}
