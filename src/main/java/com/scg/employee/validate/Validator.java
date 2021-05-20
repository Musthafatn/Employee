package com.scg.employee.validate;

import com.scg.employee.vo.DepartmentVO;
import com.scg.employee.vo.EmployeeVO;

public interface Validator {

	void validateId(final int id);

	void validateName(final String name);

	void validateAge(final int age);

	void validateSalary(final int salary);

	void validatePageNumber(final int pageNumber);

	void validateEmployee(final EmployeeVO employeeVO);

	void validateDept(final DepartmentVO departmentVO);

}
