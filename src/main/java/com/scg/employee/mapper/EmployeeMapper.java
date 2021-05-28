package com.scg.employee.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.entity.Employee;
import com.scg.employee.vo.EmployeeVO;

@Component
@Mapper(componentModel = "spring", uses = { DepartmentMapper.class, AuditMapper.class })
public interface EmployeeMapper {

	EmployeeVO toEmployeeVO(Employee employee);

	Employee toEmployee(EmployeeVO employeeVO);

	List<EmployeeVO> toEmployeeVOList(List<Employee> employeeList);

	List<Employee> toEmployeeList(List<EmployeeVO> employeeVOList);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void toEmployee(EmployeeVO employeeVO, @MappingTarget Employee employee);

}
