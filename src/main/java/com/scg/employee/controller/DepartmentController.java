package com.scg.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scg.employee.aop.ExecutionTime;
import com.scg.employee.service.DepartmentService;
import com.scg.employee.vo.DepartmentVO;

@RequestMapping("/dept")
@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public DepartmentVO insert(@RequestBody final DepartmentVO departmentVO) throws Exception {

		return departmentService.insert(departmentVO);
	}

	@GetMapping("/id/{id}")
	public DepartmentVO findById(@PathVariable final int id) throws Exception {

		return departmentService.findById(id);
	}

	@GetMapping("/name/{name}")
	public List<DepartmentVO> findByName(@PathVariable final String name) throws Exception {

		return departmentService.findByName(name);
	}

	@ExecutionTime
	@GetMapping("/list")
	public List<DepartmentVO> findAll() throws Exception {

		return departmentService.findAll();
	}

	@GetMapping("/page/{pageNumber}")
	public List<DepartmentVO> findByPage(@PathVariable final int pageNumber) throws Exception {

		return departmentService.findByPage(pageNumber);
	}

	@DeleteMapping("/{id}")
	public DepartmentVO deleteById(@PathVariable final int id) throws Exception {

		return departmentService.deleteById(id);
	}

	@PutMapping
	public DepartmentVO update(@RequestBody final DepartmentVO departmentVO) throws Exception {

		return departmentService.update(departmentVO);
	}

}
