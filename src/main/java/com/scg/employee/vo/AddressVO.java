package com.scg.employee.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AddressVO {

	private int id;
	private int empId;
	private String houseName;
	private String po;
	private String district;

}
