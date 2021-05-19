package com.scg.employee.service;

import java.util.List;

import com.scg.employee.vo.DepartmentVO;

public interface DepartmentService {

	DepartmentVO insert(DepartmentVO departmentVO) throws Exception;

	DepartmentVO findById(int id) throws Exception;

	List<DepartmentVO> findByName(String name) throws Exception;

	List<DepartmentVO> findAll() throws Exception;

	List<DepartmentVO> findByPage(int pageNumber) throws Exception;

	DepartmentVO deleteById(int id) throws Exception;

	DepartmentVO update(DepartmentVO departmentVO) throws Exception;

}
