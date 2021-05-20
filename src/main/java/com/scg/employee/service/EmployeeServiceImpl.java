package com.scg.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.employee.dao.EmployeeDAO;
import com.scg.employee.exception.DataNotFoundException;
import com.scg.employee.validate.Validator;
import com.scg.employee.vo.EmployeeVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private Validator validator;

	@Override
	public EmployeeVO insert(final EmployeeVO employeeVO) {

		validator.validateEmployee(employeeVO);
		return employeeDAO.insert(employeeVO);
	}

	@Override
	public EmployeeVO findById(final int id) {

		validator.validateId(id);
		return employeeDAO.findById(id);
	}

	@Override
	public List<EmployeeVO> findByName(final String name) {

		validator.validateName(name);
		final List<EmployeeVO> employeeVOList = employeeDAO.findByName(name);
		if (employeeVOList.isEmpty()) {
			throw new DataNotFoundException("No data found");
		}
		return employeeVOList;
	}

	@Override
	public List<EmployeeVO> findAll() {

		final List<EmployeeVO> employeeVOList = employeeDAO.findAll();
		if (employeeVOList.isEmpty()) {
			throw new DataNotFoundException("No data found");
		}
		return employeeVOList;
	}

	@Override
	public List<EmployeeVO> findByPage(final int pageNumber) {

		validator.validatePageNumber(pageNumber);
		final List<EmployeeVO> employeeVOList = employeeDAO.findByPage(pageNumber - 1);
		if (employeeVOList.isEmpty()) {
			throw new DataNotFoundException("No data found");
		}
		return employeeVOList;
	}

	@Override
	public EmployeeVO deleteById(final int id) {

		validator.validateId(id);
		return employeeDAO.deleteById(id);
	}

	@Override
	public EmployeeVO update(final EmployeeVO employeeVO) {

//		validator.validateEmployee(employeeVO);
		return employeeDAO.update(employeeVO);
	}

}
