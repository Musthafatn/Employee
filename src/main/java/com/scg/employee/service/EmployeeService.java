package com.scg.employee.service;

import java.util.List;

import com.scg.employee.vo.EmployeeVO;

public interface EmployeeService {

	EmployeeVO insert(EmployeeVO employeeVO) throws Exception;

	EmployeeVO findById(int id) throws Exception;

	List<EmployeeVO> findByName(String name) throws Exception;

	List<EmployeeVO> findAll() throws Exception;

	List<EmployeeVO> findByPage(int pageNumber) throws Exception;

	EmployeeVO deleteById(int id) throws Exception;

	EmployeeVO update(final EmployeeVO employeeVO) throws Exception;

}
