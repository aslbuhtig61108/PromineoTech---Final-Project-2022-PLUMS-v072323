package com.promineotech.finalproject.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

// This is the data transfer object (DTO) used to send a request 
// and retrieve information between services as transactions 

@Data
public class NewBookRequest {

	//@NotNull
	//private int booknumber_pk;
	
	@NotNull
	@Pattern(regexp = "[\\w\\s]*")
	private String title;
	
	@NotNull
	private String isbn;

	@NotNull
	@Pattern(regexp = "[\\w\\s]*")	
	private String book_authors;
	
	@NotNull
	@Pattern(regexp = "[\\w\\s]*")
	private Genre genre;
	
	@NotNull
	private String notes;
	
	
	
}
