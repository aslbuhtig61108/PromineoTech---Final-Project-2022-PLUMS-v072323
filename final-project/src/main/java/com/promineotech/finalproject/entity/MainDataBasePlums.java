package com.promineotech.finalproject.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainDataBasePlums {

	private int plumsid_pk;
	private int readernumber_fk;
	private int libraryid_fk;
	private int booknumber_fk;
}
