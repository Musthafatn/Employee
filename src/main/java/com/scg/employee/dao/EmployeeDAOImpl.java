package com.scg.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.entity.Employee;
import com.scg.employee.dao.repository.EmployeeRepository;
import com.scg.employee.mapper.EmployeeMapper;
import com.scg.employee.vo.EmployeeVO;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeVO insert(final EmployeeVO employeeVO) throws Exception {

		final Employee employee = employeeMapper.toEmployee(employeeVO);
		employeeRepository.save(employee);
		return employeeMapper.toEmployeeVO(employee);
	}

	@Override
	public EmployeeVO findById(final int id) throws Exception {

		final Employee employee = employeeRepository.findById(id).orElseThrow();
		return employeeMapper.toEmployeeVO(employee);
	}

	@Override
	public List<EmployeeVO> findByName(final String name) throws Exception {

		final List<Employee> entityList = employeeRepository.findByName(name);
		return employeeMapper.toEmployeeVOList(entityList);
	}

	@Override
	public List<EmployeeVO> findAll() throws Exception {

		final List<Employee> entityList = employeeRepository.findAll();
		return employeeMapper.toEmployeeVOList(entityList);
	}

	@Override
	public List<EmployeeVO> findByPage(final int pageNumber) throws Exception {

		final int pageSize = 3;
		final PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		final List<Employee> employeeList = employeeRepository.findAll(pageRequest).getContent();
		return employeeMapper.toEmployeeVOList(employeeList);
	}

	@Override
	public EmployeeVO deleteById(final int id) throws Exception {

		final Employee employee = employeeRepository.findById(id).orElseThrow();
		employeeRepository.deleteById(id);
		return employeeMapper.toEmployeeVO(employee);
	}

	@Override
	public EmployeeVO update(final EmployeeVO employeeVO) throws Exception {

		final Employee employee = employeeRepository.findById(employeeVO.getId()).orElseThrow();
		employee.setName(employeeVO.getName());
		employee.setAge(employeeVO.getAge());
		employee.setSalary(employeeVO.getSalary());
		return employeeMapper.toEmployeeVO(employeeRepository.save(employee));
	}

}
