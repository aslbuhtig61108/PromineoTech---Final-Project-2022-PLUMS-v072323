package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;
import com.promineotech.finalproject.entity.NewBookRequest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/books")
@OpenAPIDefinition(info = @Info(title = "Book Management Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })
public interface BookController {

	// formatter:off
	@Operation(
			summary = "Returns all available books",
			description = "Returns all Books found in the Books database of the PLUMS",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "All Books are listed",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Book.class))),
				@ApiResponse(
					responseCode = "500",
					description = "An unplanned error occurred.",
					content = @Content(mediaType = "application/json"))
			}	
		)

	@GetMapping ("/readsAllBooks")
	@ResponseStatus(code = HttpStatus.OK)
	List<Book> retrieveAllBooks();	
	
	@Operation(
		summary = "Returns a list of books",
		description = "Returns a list of book(s) given an ISBN Number or a Genre",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of Books is returned",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Book.class))),
			@ApiResponse(
				responseCode = "400",
				description = "The search paramters are invalid",
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404",
				description = "No Book(s) were found with the input criteria",
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500",
				description = "An unplanned error occurred.",
				content = @Content(mediaType = "application/json"))
		},	
		
		parameters = {
			@Parameter(
				name = "isbn",
				allowEmptyValue = true,
				required = false,
				description = "The unique ISBN number usually found on the back cover of the book (i.e., '000-0-0000-0000-0')"),
			@Parameter(
				name = "genre",
				allowEmptyValue = true,
				required = false,
				description = "The genre the book is categorized (i.e., 'JAVA')")
		}
	)

	@GetMapping ("/readsBooksByIsbnAndOrGenre")
	@ResponseStatus(code = HttpStatus.OK)
	List<Book> retrieveABook(
		@RequestParam(required = false)
			String isbn,
		@RequestParam(required = false)
			Genre genre);
	
	@Operation(
			summary = "Create a new entry for a book",
			description = "Returns a new book entry using user input",
			responses = { 
			    @ApiResponse(
			        responseCode = "201",
			        description = "The created Book is returned",
			        content = @Content(
			        	mediaType = "application/json",
			        	schema = @Schema(implementation = Book.class))),
			          @ApiResponse(
			            responseCode = "400", 
			            description = "The request parameters are invalid", 
			            content = @Content(mediaType = "application/json" )),
			          @ApiResponse(
			            responseCode = "404", 
			            description = "A book component was not found with the input criteria",
			            content = @Content(mediaType = "application/json" )),
			          @ApiResponse(
			            responseCode = "500", 
			            description = "An unplanned error occurred.", 
			            content = @Content(mediaType = "application/json" ))
			}
		)	
			  
	@PostMapping ("/createBook")
	@ResponseStatus(code = HttpStatus.CREATED)
	Book createNewBook(@RequestBody NewBookRequest newBookEntry);

	
	@Operation(
			summary = "Delete a book",
			description = "Delete a specific book by book number",
			
			parameters = {
				@Parameter(
					name = "booknumber_pk",
					allowEmptyValue = false,
					required = true,
					description = "Enter the book number you want to delete"
				)
			}
	)
		
	@DeleteMapping("/deleteBook")
	@ResponseStatus(code = HttpStatus.OK)
	Book deleteBook(@RequestParam int booknumber_pk);

	@Operation(
			summary = "Update a book",
			description = "Updates an existing book entry's attributes using a book's primary key.",
			responses = { 
			    @ApiResponse(
			        responseCode = "202",
			        description = "The existing book entry was successfully updated",
			        content = @Content(
			        	mediaType = "application/json",
			        	schema = @Schema(implementation = Book.class))),
			          @ApiResponse(
			            responseCode = "400", 
			            description = "The request parameters are invalid", 
			            content = @Content(mediaType = "application/json" )),

			          @ApiResponse(
			            responseCode = "500", 
			            description = "An unplanned error occurred.", 
			            content = @Content(mediaType = "application/json" ))
			},
			parameters = {
				@Parameter(
					name = "booknumber_pk",
					allowEmptyValue = false,
					required = true,
					description = "The book id of the book to be updated."),
				@Parameter(
					name = "title",
					allowEmptyValue = false,
					required = false,
					description = "The new title of the selected book"),						
				@Parameter(
					name = "isbn",
					allowEmptyValue = false,
					required = false,
					description = "The unique ISBN number of the selected book (i.e., '000-0-0000-0000-0')"),						
				@Parameter(
					name = "book_authors",
					allowEmptyValue = false,
					required = false,
					description = "The author(s) of the selected book"),
				@Parameter(
					name = "genre",
					allowEmptyValue = false,
					required = false,
					description = "The genre of the selected book (i.e., 'JAVA, EDUCATION, etc.')"),
				@Parameter(
					name = "notes",
					allowEmptyValue = false,
					required = false,
					description = "The additional notes/details of the selected book (i.e., 'condition, number of pages, etc.')")						
			}
	)
	
	// Using @RequestBody annotation is not the best approach for the Update operation
	// Further review and comparison with my Get operation (starting at LINE 51) shows the best way to manage Update user input using @Paramater (LINES 80 and 85)
	@PutMapping("/updateBook")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	Book updateBook(
		@RequestParam (required = false)
			int booknumber_pk,
		@RequestParam (required = false)
			String title,
		@RequestParam (required = false)
			String isbn,
		@RequestParam (required = false)
			String book_authors,
		@RequestParam (required = false)
			Genre genre,
		@RequestParam (required = false)
			String notes);
	// formatter:on
}
