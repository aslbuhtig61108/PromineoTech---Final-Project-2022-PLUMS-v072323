package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.finalproject.entity.Book;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
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
			summary = "Returns joined reader and books records",
			description = "Returns available joined results between the reader and the books databases.",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "All reader-books records are listed",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Book.class))),
				@ApiResponse(
					responseCode = "500",
					description = "An unplanned error occurred.",
					content = @Content(mediaType = "application/json"))
			}	
		)

	@GetMapping ("/readsAllReaderBooks")
	@ResponseStatus(code = HttpStatus.OK)
	List<Book> retrieveAllReadersAndTheirBooks();	
}
