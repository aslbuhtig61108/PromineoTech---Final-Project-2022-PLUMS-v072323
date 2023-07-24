package com.promineotech.finalproject.service;

import java.util.List;
import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;
import com.promineotech.finalproject.entity.NewBookRequest;

public interface BookService {

	List<Book> retrieveAllBooks();
	
	List<Book> retrieveABook(String isbn, Genre genre);

	Book createNewBook(NewBookRequest newBookEntry);

	Book deleteBook(int booknumber_pk);

	Book updateBook(int booknumber_pk, String title, String isbn, String book_authors, Genre genre, String notes);

}
