package com.promineotech.finalproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;
import com.promineotech.finalproject.service.BookService;
import com.promineotech.finalproject.entity.NewBookRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultBookController implements BookController {

	
	@Autowired
	private BookService bookService;
	
	// This method requests an entire list of available books in the current database
	@Override
	public List<Book> retrieveAllBooks() {
		log.debug("Controller: This operation obtains a list of all available books.");
		return bookService.retrieveAllBooks();
	}
	
	// This method requests a list of available books filtered either by isbn and genre parameters	
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.debug("Controller: ISBN={} or Genre={}", isbn, genre);
		return bookService.retrieveABook(isbn, genre);
	}

	// This method requests user input to create a new book entry and saves it to the database
	@Override
	public Book createNewBook(NewBookRequest newBookEntry) {
		log.debug("Controller: New book={}", newBookEntry);
		return bookService.createNewBook(newBookEntry);
	}

	// This method requests user input to delete a book entry	
	@Override
	public Book deleteBook(int booknumber_pk) {
		log.debug("Controller: The book with primary key ={} will be deleted", booknumber_pk);
		System.out.println("The primary key selected is: " + booknumber_pk);
		return bookService.deleteBook(booknumber_pk);
	}

	// This method requests user input to update an existing book entry	
	@Override
	public Book updateBook(int booknumber_pk, String title, String isbn, String book_authors, Genre genre,
			String notes) {
		log.debug("Controller: The book with primary key ={} will be updated", booknumber_pk);
		return bookService.updateBook(booknumber_pk, title, isbn, book_authors, genre, notes);
	}

}
