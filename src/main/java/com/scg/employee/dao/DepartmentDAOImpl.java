package com.scg.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.entity.Department;
import com.scg.employee.dao.repository.DepartmentRepository;
import com.scg.employee.exception.ApiException;
import com.scg.employee.exception.ErrorCode;
import com.scg.employee.mapper.DepartmentMapper;
import com.scg.employee.vo.DepartmentVO;

@Component
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentVO insert(final DepartmentVO departmentVO) {

		final var department = departmentMapper.toDepartment(departmentVO);
		return departmentMapper.toDepartmentVO(departmentRepository.save(department));
	}

	@Override
	public DepartmentVO findById(final int id) {

		final var department = departmentRepository.findById(id)
				.orElseThrow(() -> new ApiException(ErrorCode.DEPT_NOT_FOUND));
		return departmentMapper.toDepartmentVO(department);
	}

	@Override
	public List<DepartmentVO> findByName(final String name) {

		final List<Department> deptList = departmentRepository.findByName(name);
		return departmentMapper.toDepartmentVOList(deptList);
	}

	@Override
	public List<DepartmentVO> findAll() {

		final List<Department> deptList = departmentRepository.findAll();
		return departmentMapper.toDepartmentVOList(deptList);
	}

	@Override
	public List<DepartmentVO> findByPage(final int pageNumber) {
		final int pageSize = 3;
		final PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		final List<Department> deptList = departmentRepository.findAll(pageRequest).getContent();
		return departmentMapper.toDepartmentVOList(deptList);
	}

	@Override
	public DepartmentVO deleteById(final int id) {

		final var department = departmentRepository.findById(id)
				.orElseThrow(() -> new ApiException(ErrorCode.DEPT_NOT_FOUND));
		departmentRepository.deleteById(id);
		return departmentMapper.toDepartmentVO(department);
	}

	@Override
	public DepartmentVO update(final DepartmentVO departmentVO) {

		final var department = departmentRepository.findById(departmentVO.getId())
				.orElseThrow(() -> new ApiException(ErrorCode.DEPT_NOT_FOUND));
		department.setName(departmentVO.getName());
		return departmentMapper.toDepartmentVO(departmentRepository.save(department));
	}

}
