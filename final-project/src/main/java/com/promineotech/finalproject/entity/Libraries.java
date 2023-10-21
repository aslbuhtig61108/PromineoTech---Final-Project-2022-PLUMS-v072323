package com.promineotech.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Libraries {

	private int libraryid_pk;
	private String library_name;
	private int readernumber_fk;
}
