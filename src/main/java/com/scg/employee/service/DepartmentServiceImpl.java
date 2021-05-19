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
		try {

			return departmentDAO.insert(departmentVO);

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public DepartmentVO findById(final int id) throws Exception {
		try {

			return departmentDAO.findById(id);

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public List<DepartmentVO> findByName(final String name) throws Exception {
		try {

			final List<DepartmentVO> deptVOList = departmentDAO.findByName(name);
			if (deptVOList.isEmpty()) {
				throw new Exception("No records found");
			}
			return deptVOList;

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public List<DepartmentVO> findAll() throws Exception {
		try {

			final List<DepartmentVO> deptVOList = departmentDAO.findAll();
			if (deptVOList.isEmpty()) {
				throw new Exception("No records found");
			}
			return deptVOList;

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public List<DepartmentVO> findByPage(final int pageNumber) throws Exception {
		try {

			final List<DepartmentVO> deptVOList = departmentDAO.findByPage(pageNumber - 1);
			if (deptVOList.isEmpty()) {
				throw new Exception("No records found");
			}
			return deptVOList;

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public DepartmentVO deleteById(final int id) throws Exception {

		try {

			return departmentDAO.deleteById(id);

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public DepartmentVO update(final DepartmentVO departmentVO) throws Exception {
		try {

			return departmentDAO.update(departmentVO);

		} catch (final Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

}
