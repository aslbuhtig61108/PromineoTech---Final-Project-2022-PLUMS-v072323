package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.finalproject.entity.Reader;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/readers")
@OpenAPIDefinition(info = @Info(title = "Reader Management Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server") })

public interface ReaderController {

	// formatter:off
	@Operation(
			summary = "Returns all available readers.",
			description = "Returns all readers found in the readers database of the PLUMS",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "All readers are listed",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Reader.class))),
				@ApiResponse(
					responseCode = "500",
					description = "An unplanned error occurred.",
					content = @Content(mediaType = "application/json"))
			}	
		)

	@GetMapping ("/retrievesAllReaders")
	@ResponseStatus(code = HttpStatus.OK)
	List<Reader> getAllReaders();

}
