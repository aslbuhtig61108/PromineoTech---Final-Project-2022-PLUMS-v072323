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
		
	@Override
	public List <ReadersBooks> retrieveAllReadersAndTheirBooks(int readernumber_fk) {
		log.debug("DAO: The reader number primary key is {}", readernumber_fk);
		
		// @formatter:off
		String sql = ""
			+ "SELECT r.readernumber_pk, r.reader_id, r.phone, r.email, "
			+ "b.booknumber_pk, b.title FROM readers r "
			+ "JOIN readers_books rb ON r.readernumber_pk = rb.readernumber_fk "
			+ "JOIN books b ON b.booknumber_pk = rb.booknumber_fk "
			+ "WHERE rb.readernumber_fk = :readernumber_fk";		
		System.out.println(sql);
		System.out.println(readernumber_fk);
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("readernumber_fk", readernumber_fk);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public ReadersBooks mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				
				// @formatter:off
				return ReadersBooks.builder()
					.readernumber_fk(rs.getInt(readernumber_fk))
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

