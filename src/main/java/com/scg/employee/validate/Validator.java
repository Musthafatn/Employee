package com.scg.employee.validate;

import com.scg.employee.vo.EmployeeVO;

public interface Validator {

	void validateId(final int id) throws Exception;

	void validateName(final String name) throws Exception;

	void validateAge(final int age) throws Exception;

	void validateSalary(final int salary) throws Exception;

	void validatePageNumber(final int pageNumber) throws Exception;

	void validateEmployee(final EmployeeVO employeeVO) throws Exception;

}
