package com.scg.employee.dao;

import java.util.List;

import com.scg.employee.vo.EmployeeVO;

public interface EmployeeDAO {

	EmployeeVO insert(EmployeeVO employeeVO);

	EmployeeVO findById(int id);

	List<EmployeeVO> findByName(String name);

	List<EmployeeVO> findAll();

	List<EmployeeVO> findByPage(int pageNumber);

	EmployeeVO deleteById(int id);

	EmployeeVO update(EmployeeVO employeeVO);

	String getDept(int id);

}
