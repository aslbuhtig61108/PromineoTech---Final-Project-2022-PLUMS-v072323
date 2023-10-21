package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.finalproject.entity.ReadersBooks;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/readerbooks")
@OpenAPIDefinition(info = @Info(title = "Book Management Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })

public interface ReaderBooksController {

	// This section demonstrates the Read operation of the reader_books table.
	// formatter:off
	@Operation(
			summary = "Returns both reader and their books.",
			description = "Returns available readers and their books by readernumber and booknumber.",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "All reader-books records are listed",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = ReadersBooks.class))),
				@ApiResponse(
						responseCode = "404",
						description = "No libraries were found with the input criteria",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "500",
					description = "An unplanned error occurred.",
					content = @Content(mediaType = "application/json"))
			},
			
			// Code if user enters a book number PRIMARY KEY
			parameters = {
				@Parameter(
					name = "readernumber_fk",
					allowEmptyValue = false,
					required = true,
					description = "A reader's unique number linked to their own library.")
			}
		)

	@GetMapping ("/readsAllReaderBooks")
	@ResponseStatus(code = HttpStatus.OK)
	List <ReadersBooks> retrieveAllReadersAndTheirBooks(
		@RequestParam(required = true)
			int readernumber_fk);	
}
