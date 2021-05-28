package com.scg.employee.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class DepartmentVO {

	private Integer id;
	private String name;
	private List<EmployeeVO> employeeList;
//	private AuditVO audit;
}
