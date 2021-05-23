package com.scg.employee.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentVO {

	private int id;
	private String name;
	private List<EmployeeVO> employeeList;
//	private AuditVO audit;
}
