package com.promineotech.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadersBooks {

	private int readernumber_fk;
	private String reader_id;
	private String phone;
	private String email;
	private int booknumber_fk;
	private String title;
}
