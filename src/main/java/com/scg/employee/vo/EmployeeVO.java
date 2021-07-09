package com.scg.employee.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EmployeeVO {

	private Integer id;
	private String name;
	private Integer age;
	private Integer salary;
	private DepartmentVO department;
//	private AuditVO audit;

}
