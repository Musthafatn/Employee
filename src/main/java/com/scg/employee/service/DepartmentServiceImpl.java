package com.scg.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.employee.dao.DepartmentDAO;
import com.scg.employee.exception.DataNotFoundException;
import com.scg.employee.validate.Validator;
import com.scg.employee.vo.DepartmentVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;
	@Autowired
	private Validator validator;

	@Override
	public DepartmentVO insert(final DepartmentVO departmentVO) {

		validator.validateName(departmentVO.getName());
		return departmentDAO.insert(departmentVO);
	}

	@Override
	public DepartmentVO findById(final int id) {

		validator.validateId(id);
		return departmentDAO.findById(id);
	}

	@Override
	public List<DepartmentVO> findByName(final String name) {

		validator.validateName(name);
		final List<DepartmentVO> deptVOList = departmentDAO.findByName(name);
		if (deptVOList.isEmpty()) {
			throw new DataNotFoundException("No data found");
		}
		return deptVOList;
	}

	@Override
	public List<DepartmentVO> findAll() {

		final List<DepartmentVO> deptVOList = departmentDAO.findAll();
		if (deptVOList.isEmpty()) {
			throw new DataNotFoundException("No data found");
		}
		return deptVOList;
	}

	@Override
	public List<DepartmentVO> findByPage(final int pageNumber) {

		validator.validatePageNumber(pageNumber);
		final List<DepartmentVO> deptVOList = departmentDAO.findByPage(pageNumber - 1);
		if (deptVOList.isEmpty()) {
			throw new DataNotFoundException("No data found");
		}
		return deptVOList;
	}

	@Override
	public DepartmentVO deleteById(final int id) {

		validator.validateId(id);
		return departmentDAO.deleteById(id);
	}

	@Override
	public DepartmentVO update(final DepartmentVO departmentVO) {

		validator.validateDept(departmentVO);
		return departmentDAO.update(departmentVO);
	}

}
