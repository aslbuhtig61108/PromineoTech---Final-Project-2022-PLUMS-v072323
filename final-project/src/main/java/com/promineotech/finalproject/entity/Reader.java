package com.promineotech.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

	private int readernumber_pk;
	private String reader_id;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
}
