package com.promineotech.finalproject.dao;

import java.util.List;
import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;

public interface BookDao {

	List<Book> retrieveAllBooks();
	
	List<Book> retrieveABook(String isbn, Genre genre);

	Book saveNewBook(String title, String isbn, String book_authors, String genre, String notes);

	Book deleteBook(int booknumber_pk);

	Book updateBook(int booknumber_pk, String title, String isbn, String isbn2, String book_authors, Genre genre, String notes);



}
