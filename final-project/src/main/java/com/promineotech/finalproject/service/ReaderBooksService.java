package com.promineotech.finalproject.service;

import java.util.List;

// import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.ReadersBooks;

public interface ReaderBooksService {

	List<ReadersBooks> retrieveAllReadersAndTheirBooks(int readernumber_fk);

}
