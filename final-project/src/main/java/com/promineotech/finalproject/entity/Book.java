package com.promineotech.finalproject.entity;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Comparable <Book> {

	private int booknumber_pk;
	private String isbn;
	private Genre genre;
	private String title;
	private String book_authors;
	private String notes;
	
	@Override
	public int compareTo(Book that) {

		// @formatter:off
		return Comparator
			.comparing(Book::getBooknumber_pk)
			.thenComparing(Book::getTitle)
			.thenComparing(Book::getGenre)
			.compare(this, that);
		// @formatter:on
	}
}
