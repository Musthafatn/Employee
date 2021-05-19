package com.scg.employee.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.scg.employee.exception.InvalidInput;
import com.scg.employee.vo.EmployeeVO;

@Component
public class ValidatorImpl implements Validator {

	@Override
	public void validateId(final int id) throws Exception {

		if (id < 1) {
			throw new InvalidInput("Invalid Id");
		}

	}

	@Override
	public void validateName(final String name) throws Exception {

		final String format = "^[a-zA-Z\\s]*$";
		final Pattern pattern = Pattern.compile(new String(format));
		final Matcher matcher = pattern.matcher(name);
		if (!matcher.matches()) {
			throw new InvalidInput("Invalid name");
		}

	}

	@Override
	public void validateAge(final int age) throws Exception {

		if (age < 5 || age > 100) {
			throw new InvalidInput("Invalid Age");
		}

	}

	@Override
	public void validateSalary(final int salary) throws Exception {

		if (salary < 1000) {
			throw new InvalidInput("Invalid Salary");
		}

	}

	@Override
	public void validateEmployee(final EmployeeVO employeeVO) throws Exception {

		// validate name
		validateName(employeeVO.getName());

		// validate age
		validateAge(employeeVO.getAge());

		// validate salary
		validateSalary(employeeVO.getSalary());

		// validate dept id
		// validateId(employeeVO.getDepartmentVO().getId());

	}

	@Override
	public void validatePageNumber(final int pageNumber) throws Exception {

		if (pageNumber < 1) {
			throw new InvalidInput("Invalid page number");
		}

	}

}
