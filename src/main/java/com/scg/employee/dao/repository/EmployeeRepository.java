package com.scg.employee.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scg.employee.dao.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	@Query(value = "select * from employee where name like '%a%'", nativeQuery = true)
	@Query("select e from Employee e where e.name like %?1%")
	List<Employee> findByNameFormat(String name);

//	@Query(value = "select department.id,department.name from department inner join employee on department.id=employee.dept_id where employee.id=?1", nativeQuery = true)
	@Query("select d.id,d.name from Department d join Employee e on d.id=e.deptId where e.id=?1")
	String getDeptByEmpId(int id);

}