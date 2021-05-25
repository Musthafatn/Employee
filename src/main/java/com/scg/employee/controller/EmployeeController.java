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
import com.scg.employee.service.EmployeeService;
import com.scg.employee.vo.EmployeeVO;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public EmployeeVO insert(@RequestBody final EmployeeVO employeeVO) {

		return employeeService.insert(employeeVO);
	}

	@GetMapping("/id/{id}")
	public EmployeeVO findById(@PathVariable final int id) {

		return employeeService.findById(id);
	}

	@GetMapping("/name/{name}")
	public List<EmployeeVO> findByName(@PathVariable final String name) {

		return employeeService.findByName(name);
	}

	@ExecutionTime
	@GetMapping("/list")
	public List<EmployeeVO> findAll() {

		return employeeService.findAll();
	}

	@GetMapping("/page/{pageNumber}")
	public List<EmployeeVO> findByPage(@PathVariable final int pageNumber) {

		return employeeService.findByPage(pageNumber);
	}

	@DeleteMapping("/{id}")
	public EmployeeVO deleteById(@PathVariable final int id) {

		return employeeService.deleteById(id);
	}

	@PutMapping
	public EmployeeVO update(@RequestBody final EmployeeVO employeeVO) {

		return employeeService.update(employeeVO);
	}

	@GetMapping("/dept/{id}")
	public String getDept(@PathVariable final int id) {

		final String department = employeeService.getDept(id);
		return department;
	}

}
