package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.finalproject.entity.Libraries;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping ("/libraries")
@OpenAPIDefinition(info = @Info(title = "Book Management Service"), servers = {
	@Server(url = "http://localhost:8080", description = "Local server")})

public interface LibrariesController {
	
	// This section demonstrate the Read operation of the CRUD concept.
	// formatter:off
	@Operation(
			summary = "Returns all available reader's personal libraries.",
			description = "Returns all libraries by the library ID, library name, and reader number",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "All libraries are listed",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Libraries.class))),
				@ApiResponse(
						responseCode = "500",
						description = "An unplanned error occurred.",
						content = @Content(mediaType = "application/json"))				
			}
		)
	
	@GetMapping ("/readsAllLibraries")
	@ResponseStatus(code = HttpStatus.OK)
	List<Libraries> retrieveAllLibraries();

}
