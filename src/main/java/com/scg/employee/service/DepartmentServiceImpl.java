package com.scg.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.employee.dao.DepartmentDAO;
import com.scg.employee.vo.DepartmentVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public DepartmentVO insert(final DepartmentVO departmentVO) throws Exception {

		return departmentDAO.insert(departmentVO);
	}

	@Override
	public DepartmentVO findById(final int id) throws Exception {

		return departmentDAO.findById(id);
	}

	@Override
	public List<DepartmentVO> findByName(final String name) throws Exception {

		final List<DepartmentVO> deptVOList = departmentDAO.findByName(name);
		return deptVOList;
	}

	@Override
	public List<DepartmentVO> findAll() throws Exception {

		final List<DepartmentVO> deptVOList = departmentDAO.findAll();
		return deptVOList;
	}

	@Override
	public List<DepartmentVO> findByPage(final int pageNumber) throws Exception {

		final List<DepartmentVO> deptVOList = departmentDAO.findByPage(pageNumber - 1);
		return deptVOList;
	}

	@Override
	public DepartmentVO deleteById(final int id) throws Exception {

		return departmentDAO.deleteById(id);
	}

	@Override
	public DepartmentVO update(final DepartmentVO departmentVO) throws Exception {

		return departmentDAO.update(departmentVO);
	}

}
