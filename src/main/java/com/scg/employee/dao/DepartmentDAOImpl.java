package com.scg.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.entity.Department;
import com.scg.employee.dao.repository.DepartmentRepository;
import com.scg.employee.mapper.DepartmentMapper;
import com.scg.employee.vo.DepartmentVO;

@Component
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentVO insert(final DepartmentVO departmentVO) throws Exception {

		final Department department = departmentMapper.toDepartment(departmentVO);
		return departmentMapper.toDepartmentVO(departmentRepository.save(department));
	}

	@Override
	public DepartmentVO findById(final int id) throws Exception {

		final Department department = departmentRepository.findById(id).orElseThrow();
		return departmentMapper.toDepartmentVO(department);
	}

	@Override
	public List<DepartmentVO> findByName(final String name) throws Exception {

		final List<Department> deptList = departmentRepository.findByName(name);
		return departmentMapper.toDepartmentVOList(deptList);
	}

	@Override
	public List<DepartmentVO> findAll() throws Exception {

		final List<Department> deptList = departmentRepository.findAll();
		return departmentMapper.toDepartmentVOList(deptList);
	}

	@Override
	public List<DepartmentVO> findByPage(final int pageNumber) throws Exception {
		final int pageSize = 3;
		final PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		final List<Department> deptList = departmentRepository.findAll(pageRequest).getContent();
		return departmentMapper.toDepartmentVOList(deptList);
	}

	@Override
	public DepartmentVO deleteById(final int id) throws Exception {

		final Department department = departmentRepository.findById(id).orElseThrow();
		departmentRepository.deleteById(id);
		return departmentMapper.toDepartmentVO(department);
	}

	@Override
	public DepartmentVO update(final DepartmentVO departmentVO) throws Exception {

		final Department department = departmentRepository.findById(departmentVO.getId()).orElseThrow();
		department.setName(department.getName());
		return departmentMapper.toDepartmentVO(departmentRepository.save(department));
	}

}
