package com.scg.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.scg.employee.dao.EmployeeDAO;
import com.scg.employee.exception.ApiException;
import com.scg.employee.exception.ErrorCode;
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

	@Transactional(isolation = Isolation.REPEATABLE_READ)
	@Override
	public EmployeeVO findById(final int id) {

		validator.validateId(id);
		final EmployeeVO employeeVO = employeeDAO.findById(id);

//		log.info("Transaction1.Salary: " + employeeVO.getSalary());
//		employeeVO.setSalary(employeeVO.getSalary() + 55);
//		final EmployeeVO updatedEmployee = employeeDAO.update(employeeVO);
//		log.info("Transaction2.Salary: " + updatedEmployee.getSalary());
//		final EmployeeVO oldEmployee = employeeDAO.findById(id);
//		log.info("Transaction1.Salary: " + oldEmployee.getSalary());
//
//		oldEmployee.setSalary(oldEmployee.getSalary() + 55);
//		final EmployeeVO updatedEmployee2 = employeeDAO.update(oldEmployee);
//		log.info("Transaction2.1.Salary: " + updatedEmployee2.getSalary());
//		final EmployeeVO oldEmployee2 = employeeDAO.findById(id);
//		log.info("Transaction1.1.Salary: " + oldEmployee2.getSalary());

		return employeeVO;

	}

	@Override
	public List<EmployeeVO> findByName(final String name) {

		validator.validateName(name);
		final List<EmployeeVO> employeeVOList = employeeDAO.findByName(name);
		if (employeeVOList.isEmpty()) {
			throw new ApiException(ErrorCode.NO_DATA_FOUND);
		}
		return employeeVOList;
	}

	@Override
	public List<EmployeeVO> findAll() {

		final List<EmployeeVO> employeeVOList = employeeDAO.findAll();
		if (employeeVOList.isEmpty()) {
			throw new ApiException(ErrorCode.NO_DATA_FOUND);
		}
		return employeeVOList;
	}

	@Override
	public List<EmployeeVO> findByPage(final int pageNumber) {

		validator.validatePageNumber(pageNumber);
		final List<EmployeeVO> employeeVOList = employeeDAO.findByPage(pageNumber - 1);
		if (employeeVOList.isEmpty()) {
			throw new ApiException(ErrorCode.NO_DATA_FOUND);
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

		validator.validateEmployee(employeeVO);
		return employeeDAO.update(employeeVO);
	}

}
