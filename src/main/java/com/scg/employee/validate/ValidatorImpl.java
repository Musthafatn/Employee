package com.scg.employee.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.scg.employee.exception.DataNotFoundException;
import com.scg.employee.vo.DepartmentVO;
import com.scg.employee.vo.EmployeeVO;

@Component
public class ValidatorImpl implements Validator {

	@Override
	public void validateId(final int id) {

		if (id < 1) {
			throw new DataNotFoundException("Invalid Id");
		}

	}

	@Override
	public void validateName(final String name) {

		final String format = "^[a-zA-Z\\s]*$";
		final Pattern pattern = Pattern.compile(new String(format));
		final Matcher matcher = pattern.matcher(name);
		if (!matcher.matches()) {
			throw new DataNotFoundException("Invalid name");
		}

	}

	@Override
	public void validateAge(final int age) {

		if (age < 5 || age > 100) {
			throw new DataNotFoundException("Invalid Age");
		}

	}

	@Override
	public void validateSalary(final int salary) {

		if (salary < 1000) {
			throw new DataNotFoundException("Invalid Salary");
		}

	}

	@Override
	public void validateEmployee(final EmployeeVO employeeVO) {

		// validate name
		validateName(employeeVO.getName());

		// validate age
		validateAge(employeeVO.getAge());

		// validate salary
		validateSalary(employeeVO.getSalary());

	}

	@Override
	public void validatePageNumber(final int pageNumber) {

		if (pageNumber < 1) {
			throw new DataNotFoundException("Invalid page number");
		}

	}

	@Override
	public void validateDept(final DepartmentVO departmentVO) {

		validateId(departmentVO.getId());
		validateName(departmentVO.getName());

	}

}
