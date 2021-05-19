package com.scg.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.employee.dao.EmployeeDAO;
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
	public EmployeeVO insert(final EmployeeVO employeeVO) throws Exception {

		try {

			validator.validateEmployee(employeeVO);
			return employeeDAO.insert(employeeVO);

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public EmployeeVO findById(final int id) throws Exception {

		try {

			validator.validateId(id);
			return employeeDAO.findById(id);

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public List<EmployeeVO> findByName(final String name) throws Exception {

		try {

			validator.validateName(name);
			final List<EmployeeVO> employeeVOList = employeeDAO.findByName(name);
			if (employeeVOList.isEmpty()) {
				throw new Exception("No records found");
			}
			return employeeVOList;

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public List<EmployeeVO> findAll() {

		try {

			final List<EmployeeVO> employeeVOList = employeeDAO.findAll();
			if (employeeVOList.isEmpty()) {
				throw new Exception("No records found");
			}
			return employeeVOList;

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public List<EmployeeVO> findByPage(final int pageNumber) throws Exception {

		try {

			validator.validatePageNumber(pageNumber);
			final List<EmployeeVO> employeeVOList = employeeDAO.findByPage(pageNumber - 1);
			if (employeeVOList.isEmpty()) {
				throw new Exception("No records found");
			}
			return employeeVOList;

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public EmployeeVO deleteById(final int id) throws Exception {

		try {

			validator.validateId(id);
			return employeeDAO.deleteById(id);

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public EmployeeVO update(final EmployeeVO employeeVO) throws Exception {

		try {

			validator.validateEmployee(employeeVO);
			return employeeDAO.update(employeeVO);

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

}
