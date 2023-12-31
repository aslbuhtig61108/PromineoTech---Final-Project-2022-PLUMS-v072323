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

import com.promineotech.finalproject.entity.ReadersBooks;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultReaderBooksDao implements ReaderBooksDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	// This GET method allows the user to enter a unique reader number
	// which is passed through from the controller layer, service layer, and up into the data access object (dao) layer
	// it is recommended that once this project expands implementation of appropriate precautions against 
	// SQL injections is important
	@Override
	public List <ReadersBooks> retrieveAllReadersAndTheirBooks(int readernumber_fk) {
		log.debug("DAO: The reader number is {}", readernumber_fk);
		
		// @formatter:off
		String sql = ""
			+ "SELECT r.readernumber_pk, r.reader_id, r.phone, r.email, "
			+ "b.booknumber_pk, b.title FROM readers r "
			+ "JOIN readers_books rb ON r.readernumber_pk = rb.readernumber_fk "
			+ "JOIN books b ON b.booknumber_pk = rb.booknumber_fk "
			+ "WHERE rb.readernumber_fk = :readernumber_fk";		

		// These tools were used to troubleshoot errors during compilation and testing
		// Now that the final project behaves as intended, these tools have been commented out
//		System.out.println(sql);
//		System.out.println(readernumber_fk);
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("readernumber_fk", readernumber_fk);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public ReadersBooks mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				// @formatter:off
				return ReadersBooks.builder()
					.readernumber_fk(readernumber_fk)
					.reader_id(rs.getString("reader_id"))
					.phone(rs.getString("phone"))
					.email(rs.getString("email"))
					.booknumber_fk(rs.getInt("booknumber_pk"))
					.title(rs.getString("title"))
					.build();
				// @formatter:on
			}});
		}
}

