package com.scg.employee.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EmployeeVO {

	private int id;
	private String name;
	private int age;
	private int salary;
	private int deptId;
//	private DepartmentVO department;
//	private AuditVO audit;

}
