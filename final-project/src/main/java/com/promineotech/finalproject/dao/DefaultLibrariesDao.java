package com.promineotech.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


import com.promineotech.finalproject.entity.Libraries;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultLibrariesDao implements LibrariesDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Libraries> retrieveAllLibraries() {
		log.debug("DAO: All available libraries should populate.");
		
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM libraries";
		// @formatter:on
		
		return jdbcTemplate.query(sql, new RowMapper<>() {
			
			@Override
			public Libraries mapRow(ResultSet rs, int rowNum) throws SQLException {

				// @formatter:off
				return Libraries.builder()
						.libraryid_pk(rs.getInt("libraryid_pk"))
						.library_name(rs.getString("library_name"))
						.readernumber_fk(rs.getInt("readernumber_fk"))
						.build();
				// @formatter:on
			}
			
		}
				);
	}

}
