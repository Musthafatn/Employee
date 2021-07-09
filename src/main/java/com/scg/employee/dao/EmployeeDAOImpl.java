package com.scg.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.entity.Employee;
import com.scg.employee.dao.repository.EmployeeRepository;
import com.scg.employee.exception.ApiException;
import com.scg.employee.exception.ErrorCode;
import com.scg.employee.mapper.EmployeeMapper;
import com.scg.employee.vo.EmployeeVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Autowired
//	private AddressProxy addressProxy;

	@Override
	public EmployeeVO insert(final EmployeeVO employeeVO) {

		final var employee = employeeMapper.toEmployee(employeeVO);
		employeeRepository.save(employee);
		return employeeMapper.toEmployeeVO(employee);
	}

	@Override
	public EmployeeVO findById(final int id) {

		final var employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_FOUND));

//		final String address = addressProxy.getAddressByEmpId(id);
//		log.info(address);

		return employeeMapper.toEmployeeVO(employee);
	}

	@Override
	public List<EmployeeVO> findByName(final String name) {

		final List<Employee> entityList = employeeRepository.findByNameFormat(name);
		return employeeMapper.toEmployeeVOList(entityList);
	}

	@Override
	public List<EmployeeVO> findAll() {

		final List<Employee> entityList = employeeRepository.findAll();
		return employeeMapper.toEmployeeVOList(entityList);
	}

	@Override
	public List<EmployeeVO> findByPage(final int pageNumber) {

		final var pageSize = 3;
		final var pageRequest = PageRequest.of(pageNumber, pageSize);
		final List<Employee> employeeList = employeeRepository.findAll(pageRequest).getContent();
		return employeeMapper.toEmployeeVOList(employeeList);
	}

	@Override
	public EmployeeVO deleteById(final int id) {

		final var employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_FOUND));
		employeeRepository.deleteById(id);
		return employeeMapper.toEmployeeVO(employee);
	}

//	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public EmployeeVO update(final EmployeeVO employeeVO) {

		final var employee = employeeRepository.findById(employeeVO.getId())
				.orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_FOUND));
		employeeMapper.toEmployee(employeeVO, employee);
		return employeeMapper.toEmployeeVO(employeeRepository.save(employee));
	}

	@Override
	public String getDept(final int id) {

//		return employeeRepository.getDeptByEmpId(id);
		return null;
	}

}
