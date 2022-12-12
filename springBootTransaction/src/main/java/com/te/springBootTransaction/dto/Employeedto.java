package com.te.springBootTransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeedto {

	private String employeeName;
	private String email;
	private String departmentName;
}
