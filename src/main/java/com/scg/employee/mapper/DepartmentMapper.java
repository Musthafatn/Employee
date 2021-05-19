package com.scg.employee.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.entity.Department;
import com.scg.employee.vo.DepartmentVO;

@Component
@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface DepartmentMapper {

	DepartmentVO toDepartmentVO(Department Department);

	Department toDepartment(DepartmentVO DepartmentVO);

	List<DepartmentVO> toDepartmentVOList(List<Department> departmentList);

	List<Department> toDepartmentList(List<DepartmentVO> departmentVOList);

}
