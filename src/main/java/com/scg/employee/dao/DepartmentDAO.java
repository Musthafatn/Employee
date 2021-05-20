package com.scg.employee.dao;

import java.util.List;

import com.scg.employee.vo.DepartmentVO;

public interface DepartmentDAO {

	DepartmentVO insert(DepartmentVO departmentVO);

	DepartmentVO findById(int id);

	List<DepartmentVO> findByName(String name);

	List<DepartmentVO> findAll();

	List<DepartmentVO> findByPage(int pageNumber);

	DepartmentVO deleteById(int id);

	DepartmentVO update(DepartmentVO departmentVO);

}
