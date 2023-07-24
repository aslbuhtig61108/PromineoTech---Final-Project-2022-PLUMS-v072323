package com.promineotech.finalproject.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.finalproject.dao.BookDao;
import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;
import com.promineotech.finalproject.entity.NewBookRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBookService implements BookService {

	@Autowired
	private BookDao bookDao;

	@Transactional (readOnly = true)
	@Override
	public List<Book> retrieveAllBooks() {
		log.info("The retrieveAllBooks method was called without any parameters");		
		return bookDao.retrieveAllBooks();
	}
	
	@Transactional (readOnly = true)
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.info("The retrieveABook method was"
			+ " called with an ISBN={} or Genre={}",isbn, genre);
		List<Book> books = bookDao.retrieveABook(isbn, genre);
		
		if (books.isEmpty()) {
			String errorMessage = String.format("No books were found with"
				+ " the provided isbn=%s and/or genre=%s", isbn, genre);
			throw new NoSuchElementException(errorMessage);
			
		}
		Collections.sort(books);
		return books;
	}

	@Transactional
	@Override
	public Book createNewBook(NewBookRequest newBookEntry) {
		log.info("Service: New book={}", newBookEntry);
		
		String title = newBookEntry.getTitle();
		String isbn = newBookEntry.getIsbn();
		String book_authors = newBookEntry.getBook_authors();
		String genre = newBookEntry.getGenre().toString();
		String notes = newBookEntry.getNotes();
		
		System.out.println(book_authors);
		
		return bookDao.saveNewBook(title, isbn, book_authors, genre, notes);
	}

	@Override
	public Book deleteBook(int booknumber_pk) {
		log.info("Service: The book number = {}", booknumber_pk);
		System.out.println("The primary key is: " + booknumber_pk);
		return bookDao.deleteBook(booknumber_pk);
	}

	@Override
	public Book updateBook(int booknumber_pk, String title, String isbn, String book_authors, Genre genre,
			String notes) {
		log.info("Service: The book number = {} will be updated", booknumber_pk);
		return bookDao.updateBook(booknumber_pk, title, isbn, isbn, book_authors, genre, notes);
	}

}
