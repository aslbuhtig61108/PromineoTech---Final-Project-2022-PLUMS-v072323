package com.promineotech.finalproject.service;

import java.util.List;

import com.promineotech.finalproject.entity.Book;

public interface ReaderBooksService {

	List<Book> retrieveAllReaderAndTheirBooks();

}
