package com.promineotech.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.finalproject.entity.Reader;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultReaderDao implements ReaderDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Reader> getAllReaders() {
		log.debug("DAO: All available readers should be displayed");
		
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM readers";
		// @formatter:on
		
		return jdbcTemplate.query(sql, new RowMapper<>() {
			
			@Override
			public Reader mapRow(ResultSet rs, int rowNum) throws SQLException {

				// @formatter:off
				return Reader.builder()
					.readernumber_pk(rs.getInt("readernumber_pk"))
					.reader_id(rs.getString("reader_id"))
					.first_name(rs.getString("first_name"))
					.last_name(rs.getString("last_name"))
					.phone(rs.getString("phone"))
					.email(rs.getString("email"))
					.build();
				// @formatter:on
			}
		});

	}

}
