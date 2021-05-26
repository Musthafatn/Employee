package com.scg.employee.validate;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.scg.employee.exception.ApiException;
import com.scg.employee.exception.ErrorCode;
import com.scg.employee.vo.DepartmentVO;
import com.scg.employee.vo.EmployeeVO;

@Component
public class ValidatorImpl implements Validator {

	@Override
	public void validateId(final int id) {

		if (id < 1) {
			throw new ApiException(ErrorCode.INVALID_ID);
		}

	}

	@Override
	public void validateName(final String name) {

		final var format = "^[a-zA-Z\\s]*$";
		final var pattern = Pattern.compile(format);
		final var matcher = pattern.matcher(name);
		if (!matcher.matches()) {
			throw new ApiException(ErrorCode.INVALID_NAME);
		}

	}

	@Override
	public void validateAge(final int age) {

		if (age < 5 || age > 100) {
			throw new ApiException(ErrorCode.INVALID_AGE);
		}

	}

	@Override
	public void validateSalary(final int salary) {

		if (salary < 1000) {
			throw new ApiException(ErrorCode.INVALID_SALARY);
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
			throw new ApiException(ErrorCode.INVALID_PAGE);
		}

	}

	@Override
	public void validateDept(final DepartmentVO departmentVO) {

		validateId(departmentVO.getId());
		validateName(departmentVO.getName());

	}

}
