package com.scg.employee.service;

import java.util.List;

import com.scg.employee.vo.EmployeeVO;

public interface EmployeeService {

	EmployeeVO insert(EmployeeVO employeeVO);

	EmployeeVO findById(int id);

	List<EmployeeVO> findByName(String name);

	List<EmployeeVO> findAll();

	List<EmployeeVO> findByPage(int pageNumber);

	EmployeeVO deleteById(int id);

	EmployeeVO update(final EmployeeVO employeeVO);

	String getDept(int id);

}
