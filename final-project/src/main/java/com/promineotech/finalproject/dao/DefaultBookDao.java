package com.promineotech.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBookDao implements BookDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	// This method retrieves a list of all available books from the books table
	@Override
	public List<Book> retrieveAllBooks() {
		log.debug("DAO: All available books should be displayed");

		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM books";
		// @formatter: on
		
		return jdbcTemplate.query(sql, new RowMapper<>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				// @formatter:off
				return Book.builder()
					.booknumber_pk(rs.getInt("booknumber_pk"))
					.title(rs.getString("title"))
					.isbn(rs.getString("isbn"))
					.book_authors(rs.getString("book_authors"))
					.genre(Genre.valueOf(rs.getString("genre")))
					.notes(rs.getString("notes"))
					.build();
					
				// @formatter:on
			}

		});
	}
	
	// Retrieves a list of books either by isbn and/or genre
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.debug("DAO: ISBN={} or Genre={}",isbn, genre);
		
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM books "
			+ "WHERE isbn = :isbn OR genre = :genre";
		
		// @formatter:on
		Map<String, Object> params = new HashMap<>();
			params.put("isbn", isbn);
			params.put("genre", genre.toString());
		
		// Use a rowmapper to generate a list
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Book.builder()
					.booknumber_pk(rs.getInt("booknumber_pk"))
					.title(rs.getString("title"))
					.isbn(rs.getString("isbn"))
					.genre(Genre.valueOf(rs.getString("genre")))
					.book_authors(rs.getString("book_authors"))
					.notes(rs.getString("notes"))
					.build();
				// @formatter:on
			}});
	}

	// Saves a new book entry 
	@Override
	public Book saveNewBook(String title, String isbn,
			String book_authors, String genre, String notes) {
		log.debug("DAO: New book with title={}, isbn={}, authors={},"
			   + " genre= {}, and notes= {}", title, isbn, book_authors, genre, notes);
		
		// @formatter:off
		String sql = ""
			+ "INSERT INTO books ("
			+ "title, isbn, book_authors, genre, notes"
			+ ") VALUES ("
			+ ":title, :isbn, :book_authors, :genre, :notes)";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("title", title);
		params.put("isbn", isbn);
		params.put("book_authors", book_authors);
		params.put("genre", genre);
		params.put("notes", notes);
		
		jdbcTemplate.update(sql, params);
		
		// @formatter:off
		return Book.builder()
			.title(title)
			.isbn(isbn)
			.book_authors(book_authors)
			.genre(null)
			.notes(notes)
			.build();
		// @formatter:on	
	}

	// Deletes an existing book entry	
	@Override
	public Book deleteBook(int booknumber_pk) {
		log.debug("DAO: The book that was deleted has primary key ={}", booknumber_pk);
		
		// @formatter:off
		String sql = "DELETE FROM books WHERE "
			+ "booknumber_pk = :booknumber_pk";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("booknumber_pk", booknumber_pk);

		jdbcTemplate.update(sql, params);
//		Optional<Book> deletedBook = new Book();
				
		return Book.builder().booknumber_pk(booknumber_pk).build();
	}

	// Updates an existing book entry
	@Override
	public Book updateBook(int booknumber_pk, String title, String isbn, String isbn2, String book_authors,
			Genre genre, String notes) {

		log.debug("DAO: The book with primary key = {} was updated.", booknumber_pk);
		
		String sql = "" + "UPDATE books SET title = :title, isbn = :isbn,"
				+ " book_authors = :book_authors, genre = :genre, notes = :notes"
				+ " WHERE booknumber_pk = :booknumber_pk";
		
		Map<String, Object> params = new HashMap<>();
		params.put("booknumber_pk", booknumber_pk);
		params.put("title",title);
		params.put("isbn", isbn);
		params.put("book_authors", book_authors);
		params.put("genre", genre.toString());
		params.put("notes", notes);
				
		jdbcTemplate.update(sql, params);
		return Book.builder()
			.booknumber_pk(booknumber_pk)
			.title(title)
			.isbn(isbn)
			.book_authors(book_authors)
			.genre(genre)
			.notes(notes)
			.build();
	}
}
